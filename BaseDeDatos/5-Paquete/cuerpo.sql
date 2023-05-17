CREATE OR REPLACE PACKAGE BODY utilidades_calendario AS
--------------------------------------------------------------------------------
PROCEDURE generar_calendario
    (p_hora_inicio IN varchar2,
     p_ubicacion IN varchar2,
     p_cod_split IN splits.cod_split%TYPE)
AS

    TYPE record_lista_cod_equipo IS RECORD(
        cod_equipo equipos.cod_equipo%TYPE
    );
    
    TYPE varray_lista_cod_equipo IS VARRAY(12) OF record_lista_cod_equipo;
    
    TYPE tabla_lista_cod_equipo IS TABLE OF record_lista_cod_equipo INDEX BY PLS_INTEGER;
    
    TYPE record_partidos IS RECORD (
        cod_equipo1 equipos.cod_equipo%TYPE,
        cod_equipo2 equipos.cod_equipo%TYPE
    );
    
    TYPE table_partidos IS TABLE OF record_partidos INDEX BY PLS_INTEGER;
    
    CURSOR cursor_lista_cod_equipo IS 
        SELECT cod_equipo FROM registros_equipos 
        WHERE cod_temporada = 0;
    
    array_equipos varray_lista_cod_equipo := varray_lista_cod_equipo();
    tabla_equipos tabla_lista_cod_equipo;
    array_partidos table_partidos;
    
    
    v_fecha date;
    
    v_verificar_numero_splits NUMBER;
    
    --excepciones
    
    non_numeric EXCEPTION;
    PRAGMA EXCEPTION_INIT(non_numeric, -1858);
    
    jornada_ya_existente EXCEPTION;
    PRAGMA EXCEPTION_INIT(jornada_ya_existente, -01422);
    
    formato_no_conforme EXCEPTION;
    PRAGMA EXCEPTION_INIT(formato_no_conforme,- 01862);
    
    formato_no_conforme_dos EXCEPTION;
    PRAGMA EXCEPTION_INIT(formato_no_conforme, -01850);
BEGIN

    SELECT COUNT(*) INTO v_verificar_numero_splits FROM jornadas WHERE cod_split = p_cod_split;
    IF (v_verificar_numero_splits > 0)
    THEN
        RAISE jornada_ya_existente;
    END IF;

    FOR cod_equipo IN cursor_lista_cod_equipo LOOP
        array_equipos.EXTEND;
        array_equipos(array_equipos.LAST).cod_equipo := cod_equipo.cod_equipo;
    END LOOP;
    
    select fecha_inicio into v_fecha from splits where cod_split = p_cod_split;

    declare
        v_index_min NUMBER;
        v_index_min2 number;
        v_index_max NUMBER;
        v_temp record_partidos;
        v_equipo_encontrado boolean := false;
        
        v_intervalo_jornada number := 7;
        v_cod_jornada jornadas.cod_jornada%type;
        v_hora timestamp := TO_TIMESTAMP(TO_CHAR(v_fecha, 'YYYY-MM-DD') || p_hora_inicio, 'YYYY-MM-DD HH24:MI');
    begin
        FOR x in 1..11 Loop
            insert into jornadas values(p_cod_split, default, x, v_fecha, p_ubicacion);
            
            FOR indice_bucle in array_equipos.first..array_equipos.last
            loop
                tabla_equipos(indice_bucle).cod_equipo := array_equipos(indice_bucle).cod_equipo;
            end loop;
             
            v_index_max := tabla_equipos.COUNT;
            FOR i IN 1..6 LOOP
                while not v_equipo_encontrado
                loop
                    v_index_min := TRUNC(DBMS_RANDOM.VALUE(1, v_index_max +1));
                    if tabla_equipos.exists(v_index_min)
                    then
                        v_equipo_encontrado := true;
                    end if;
                end loop;
               
                v_temp.cod_equipo1 := tabla_equipos(v_index_min).cod_equipo;
                v_equipo_encontrado := false;
                
                LOOP
                    while not v_equipo_encontrado
                    loop
                        v_index_min2 := TRUNC(DBMS_RANDOM.VALUE(1, v_index_max + 1));
                        if tabla_equipos.exists(v_index_min2)
                        then
                            v_equipo_encontrado := true;
                        end if;
                    end loop;
                    v_equipo_encontrado := false;
    
                    
                    IF v_temp.cod_equipo1 <> tabla_equipos(v_index_min2).cod_equipo 
                    THEN
                        v_temp.cod_equipo2 := tabla_equipos(v_index_min2).cod_equipo;
                        EXIT;
                    END IF;
                END LOOP;
                
                array_partidos(i) := v_temp;
                
                tabla_equipos.DELETE(v_index_min);
                tabla_equipos.DELETE(v_index_min2);

            END LOOP;
                select cod_jornada into v_cod_jornada from jornadas where cod_split = p_cod_split and numero = x;
                for m in array_partidos.first..array_partidos.last
                loop
                    insert into partidos values(v_cod_jornada, default, array_partidos(m).cod_equipo1, array_partidos(m).cod_equipo2, v_hora, default);
                    v_hora := v_hora + INTERVAL '1' hour;
                end loop;
                v_fecha := v_fecha + v_intervalo_jornada;
                v_hora  := TO_TIMESTAMP(TO_CHAR(v_fecha, 'YYYY-MM-DD') || p_hora_inicio, 'YYYY-MM-DD HH24:MI');
        end loop;
    end;
    
    COMMIT;
    
EXCEPTION
    WHEN non_numeric THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN jornada_ya_existente THEN
        DBMS_OUTPUT.PUT_LINE('Error: ya existen jornadas para el split: ' || p_cod_split);
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: no existe el split: ' || p_cod_split);
    WHEN formato_no_conforme THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN formato_no_conforme_dos THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN OTHERS THEN    
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END generar_calendario;
--------------------------------------------------------------------------------
PROCEDURE generar_playoff
    (p_hora_inicio IN varchar2,
     p_ubicacion IN varchar2,
     p_cod_split IN splits.cod_split%type)
AS
    v_cod_jornada jornadas.cod_jornada%type;
    
    TYPE record_lista_cod_equipo IS RECORD(
        cod_equipo equipos.cod_equipo%TYPE
    );
    
    TYPE varray_lista_cod_equipo IS VARRAY(8) OF record_lista_cod_equipo;
    
    CURSOR cursor_lista_cod_equipo IS 
        SELECT cod_equipo FROM clasificaciones 
        WHERE cod_split = p_cod_split and posicion <= 8 ORDER BY posicion ASC;
    
    array_equipos varray_lista_cod_equipo := varray_lista_cod_equipo();
    
    v_index_2 number;
    v_numero_jornada number;
    v_fecha date;
    
    non_numeric EXCEPTION;
    PRAGMA EXCEPTION_INIT(non_numeric, -1858);
    
    formato_no_conforme EXCEPTION;
    PRAGMA EXCEPTION_INIT(formato_no_conforme,- 01862);
    
    formato_no_conforme_dos EXCEPTION;
    PRAGMA EXCEPTION_INIT(formato_no_conforme, -01850);
    
    datos_insuficientes EXCEPTION;
    PRAGMA EXCEPTION_INIT(datos_insuficientes, -06502);
    
BEGIN

    FOR cod_equipo IN cursor_lista_cod_equipo LOOP
        array_equipos.EXTEND;
        array_equipos(array_equipos.LAST).cod_equipo := cod_equipo.cod_equipo;
    END LOOP;

    select numero, fecha into v_numero_jornada, v_fecha from jornadas where cod_split = p_cod_split and numero = (select max(numero) from jornadas where cod_split = p_cod_split);
    select max(numero) into v_numero_jornada from jornadas where cod_split = p_cod_split;
    v_numero_jornada := v_numero_jornada + 1;
    insert into jornadas values(p_cod_split, default, v_numero_jornada, v_fecha + 7 , p_ubicacion);
    select cod_jornada into v_cod_jornada from jornadas where cod_split = p_cod_split and numero = v_numero_jornada;
       
    DECLARE
        v_hora timestamp := TO_TIMESTAMP(TO_CHAR(v_fecha + 7, 'YYYY-MM-DD') || p_hora_inicio, 'YYYY-MM-DD HH24:MI');
    BEGIN
        FOR v_index IN array_equipos.FIRST..(array_equipos.LAST/2)
        LOOP
            v_index_2 := array_equipos.LAST - (v_index - 1);
            insert into partidos values(v_cod_jornada, default, array_equipos(v_index).cod_equipo, array_equipos(v_index_2).cod_equipo, v_hora, default);
            v_hora := v_hora + INTERVAL '1' hour;
        END LOOP;
    END;
    
    COMMIT;
    
EXCEPTION
    WHEN non_numeric THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN formato_no_conforme THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN formato_no_conforme_dos THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario introducir la hora en formato string (HH24:MM).');
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario tener mínimo 8 equipos clasificados en el split: ' || p_cod_split);
    WHEN datos_insuficientes THEN
        DBMS_OUTPUT.PUT_LINE('Error: es necesario tener mínimo 8 equipos clasificados en el split: ' || p_cod_split);
    when others
    then    
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;

--------------------------------------------------------------------------------

PROCEDURE calcularClasificacion
    (p_cod_split splits.cod_split%type)
AS
    TYPE record_equipo IS RECORD(
        cod_equipo equipos.cod_equipo%TYPE,
        victorias NUMBER
    );
    
    TYPE tabla_equipos IS TABLE OF record_equipo INDEX BY PLS_INTEGER;
    
    CURSOR resultados IS
        SELECT cod_equipo
        FROM informacion_partidos ip, partidos p, jornadas j
        WHERE resultado = 'v' 
        AND ip.cod_partido = p.cod_partido
        AND p.cod_jornada = j.cod_jornada
        AND j.cod_split = p_cod_split
        GROUP BY cod_equipo ORDER BY COUNT(resultado) DESC;
        
    v_tabla_equipos tabla_equipos;
    v_equipo record_equipo;
BEGIN
    OPEN resultados;
    
    LOOP
        FETCH resultados INTO v_equipo.cod_equipo;
        EXIT WHEN resultados%NOTFOUND;
        
        v_tabla_equipos(v_tabla_equipos.COUNT + 1) := v_equipo;
        
        DBMS_OUTPUT.PUT_LINE(v_equipo.cod_equipo);
    END LOOP;
    
    CLOSE resultados;
    
    FOR i IN v_tabla_equipos.FIRST .. v_tabla_equipos.LAST LOOP
        insert into clasificaciones values(p_cod_split, v_tabla_equipos(i).cod_equipo, i);
    END LOOP;
    
END calcularClasificacion;

--------------------------------------------------------------------------------
procedure habilitar_desabilitar_trigger
(p_op in varchar2) as
begin

    if p_op = 'habilitar' then
    
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_splits  enable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_jornadas enable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_partidos enable';
    
    elsif p_op = 'deshabilitar' then
    
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_splits disable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER  bloquear_jornadas  disable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER  bloquear_partidos  disable';
        end if;
        
    end habilitar_desabilitar_trigger;

    
    
END utilidades_calendario;

