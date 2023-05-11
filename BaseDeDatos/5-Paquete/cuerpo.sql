CREATE OR REPLACE PACKAGE BODY utilidades_calendario AS
--------------------------------------------------------------------------------
PROCEDURE generar_calendario
    (p_fecha IN date,
     p_ubicacion IN varchar2,
     p_cod_temporada IN temporadas.cod_temporada%TYPE,
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

BEGIN
    -- Populating array_equipos with teams
    FOR cod_equipo IN cursor_lista_cod_equipo LOOP
        array_equipos.EXTEND;
        array_equipos(array_equipos.LAST).cod_equipo := cod_equipo.cod_equipo;
    END LOOP;
    
    
    
    declare
        v_index_min NUMBER;
        v_index_min2 number;
        v_index_max NUMBER;
        v_temp record_partidos;
        v_equipo_encontrado boolean := false;
        
        v_fecha date:= p_fecha;
        v_intervalo_jornada number := 7;
        v_cod_jornada jornadas.cod_jornada%type;
        v_hora timestamp := TO_TIMESTAMP(TO_CHAR(v_fecha, 'YYYY-MM-DD') || '16:00', 'YYYY-MM-DD HH24:MI');
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
                v_hora := TO_TIMESTAMP(TO_CHAR(v_fecha, 'YYYY-MM-DD') || '16:00', 'YYYY-MM-DD HH24:MI');
        end loop;
    end;
    
EXCEPTION
    when others
    then    
        DBMS_OUTPUT.PUT_LINE('Ha occurido un error: ' || SQLERRM);
END generar_calendario;

--------------------------------------------------------------------------------

PROCEDURE generar_playoff_jornada_semifinal
    (v_cod_split IN splits.cod_split%type)
AS
    v_cod_jornada jornadas.cod_jornada%type;
    
    TYPE record_lista_cod_equipo IS RECORD(
        cod_equipo equipos.cod_equipo%TYPE
    );
    
    TYPE varray_lista_cod_equipo IS VARRAY(8) OF record_lista_cod_equipo;
    
    CURSOR cursor_lista_cod_equipo IS 
        SELECT cod_equipo FROM clasificaciones 
        WHERE cod_split = v_cod_split and posicion <= 8 ORDER BY posicion ASC;
    
    array_equipos varray_lista_cod_equipo := varray_lista_cod_equipo();
    
    v_index_2 number;
    v_numero_jornada number;
BEGIN

    FOR cod_equipo IN cursor_lista_cod_equipo LOOP
        array_equipos.EXTEND;
        array_equipos(array_equipos.LAST).cod_equipo := cod_equipo.cod_equipo;
    END LOOP;
    

    select max(numero) into v_numero_jornada from jornadas where cod_split = v_cod_split;
    v_numero_jornada := v_numero_jornada + 1;
    insert into jornadas values(v_cod_split, default, v_numero_jornada, SYSDATE + 1, 'EN EL FIN DEL MUNDO');
    select cod_jornada into v_cod_jornada from jornadas where cod_split = v_cod_split and numero = v_numero_jornada;
    
    
    FOR v_index IN array_equipos.FIRST..(array_equipos.LAST/2)
    LOOP
        v_index_2 := array_equipos.LAST - (v_index - 1);
        insert into partidos values(v_cod_jornada, default, array_equipos(v_index).cod_equipo, array_equipos(v_index_2).cod_equipo, SYSTIMESTAMP, default);
    END LOOP;
    
EXCEPTION
    when others
    then    
        DBMS_OUTPUT.PUT_LINE('Ha occurido un error: ' || SQLERRM);
END;
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

