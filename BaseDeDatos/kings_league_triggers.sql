drop trigger max_jugadores;
drop trigger min_jugadores;
drop trigger min_equipos;


create or replace trigger min_equipos
before insert on splits
declare
    numeroEquipos number;
begin
    select count(*) into numeroEquipos from equipos_participantes
    where cod_temporada = (select max(cod_temporada) from temporadas);
    
    if numeroEquipos < 12
    then 
        raise_application_error(-20001, 'Tiene que haber un mínimo de 12 equipos para generar el calendario');
    end if;
    
end;

/

create or replace trigger min_jugadores
before insert on equipos_participantes
for each row
declare
    codEquipo equipos.cod_equipo%type := :new.cod_equipo;
    numeroJugadores number;
begin
    
    select count(*) into numeroJugadores
    from contratos_equipo_jugador
    where cod_equipo = codEquipo
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if (numeroJugadores < 8)
    then
        raise_application_error(-20001, 'El equipo tiene que tener un mínimo de 8 jugadores');
    end if;
    
end;


/
create or replace trigger max_jugadores_draft
before insert on contratos_equipo_jugador
for each row
declare
    numeroContratos number;
    estaEnDraft number;
begin
    select count(*) into numeroContratos
    from contratos_equipo_jugador cj, draft d
    where cod_equipo = :new.cod_equipo 
    and cj.cod_jugador = d.cod_jugador 
    and d.cod_temporada = (select max(cod_temporada) from temporadas)
    and (fecha_fin > sysdate or fecha_fin is null);
    
    select count(*) into estaEnDraft from draft where cod_jugador = :new.cod_jugador
    and cod_temporada = (select max(cod_temporada) from temporadas);
    
    if numeroContratos >= 8 and estaEnDraft > 0
    then 
        raise_application_error(-20001, 'El equipo ya tiene 8 jugadores');
    end if;
    
end max_jugadores;

/


create or replace trigger max_jugadores_wild_card
before insert on contratos_equipo_jugador
for each row
declare
    numeroContratos number;
begin
    select count(*) into numeroContratos
    from contratos_equipo_jugador cj
    where cod_equipo = :new.cod_equipo 
    and cj.cod_jugador not in (select cod_jugador from draft where cod_temporada = (select max(cod_temporada) from temporadas))
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if numeroContratos >= 2
    then 
        raise_application_error(-20001, 'El equipo ya tiene 2 jugadores fuera del draft');
    end if;
    
end max_jugadores;
/
create or replace trigger min_clausula_inicial
    before insert or update on contratos_equipo_jugador
    for each row
        begin
            if :new.clausula < 1000000 then
                raise_application_error(-20004, 'La clausula minima inicial es de 1.000.000');
            end if;
end min_clausula_inicial;

-- controlar que solo haya un entrenador

create or replace trigger control_miembros
before insert or update on contratos_equipo_miembro
for each row
declare
    numberoDeMiembros number;
begin
    select count(*) into numberoDeMiembros
    from contratos_equipo_miembro
    where cod_equipo = :new.cod_equipo
    and funcion = :new.funcion
    and (fecha_salida > sysdate or fecha_salida is null);
    
    if numberoDeMiembros >= 1
    then
        raise_application_error(-20001, 'No puede haber más de un miembro con la misma función');
    end if;
    
end control_miembros;

CREATE OR REPLACE TRIGGER max_presupuesto_equipo
before INSERT OR UPDATE on contratos_equipo_jugador
for each row
declare
    v_clausula number;
    v_salario number;
    v_pres_max number;
  BEGIN
    SELECT presupuesto INTO v_pres_max
    FROM equipos
    WHERE cod_equipo = :new.cod_equipo;
         
    SELECT SUM(salario), SUM(clausula) INTO v_salario, v_clausula
    FROM contratos_equipo_jugador
    WHERE cod_equipo = :new.cod_equipo
    AND (fecha_fin > sysdate OR fecha_fin IS NULL);
    
    if (v_salario + v_clausula) > 200000000
    then
    raise_application_error(-20001, 'no puede sobrepasarse el presupuesto
    establecido');
    end if;

END max_presupuesto_equipo;

CREATE OR REPLACE TRIGGER check_contrato_jugador_split
BEFORE INSERT OR UPDATE OF cod_jugador, fecha_inicio, fecha_fin
ON contratos_equipo_jugador
FOR EACH ROW
DECLARE
	v_count INTEGER;
BEGIN
	SELECT COUNT(*) INTO v_count
	FROM contratos_equipo_jugador
	WHERE cod_jugador = :NEW.cod_jugador
	AND (fecha_fin > sysdate

	or fecha_fin is null);
    
	IF v_count > 0 THEN
    	RAISE_APPLICATION_ERROR(-20001, 'Este jugador ya tiene un contrato activo');
	END IF;
END;



create or replace trigger bloquear_splits
before insert or update on splits
for each row
declare
begin
    raise_application_error(-20001, 'No se pueden modifcar splits antes o después de generar el calendario');
end;
/

alter trigger bloquear_splits disable;


create or replace trigger bloquear_jornadas
before insert or update on splits
for each row
declare
begin
    raise_application_error(-20001, 'No se pueden modifcar jornadas antes o después de generar el calendario');
end;

alter trigger bloquear_jornadas disable;

create or replace trigger bloquear_partidos
before insert or update on splits
for each row
declare
begin
    raise_application_error(-20001, 'No se pueden modifcar partidos antes o después de generar el calendario');
end;

alter trigger bloquear_partidos disable;

-- Los triggers están desactivo por defecto. Se activaran cuando se genere el calendario mediante el procedimiento
-- si se desea modificar durante lo jornada, solo se podra desactivar utilizando un procedimiento del paquete calendario



CREATE OR REPLACE TRIGGER equipo_duplicado_tr
BEFORE INSERT or update ON equipos
FOR EACH ROW
    DECLARE v_num_equi INT;
BEGIN

    SELECT COUNT(*) into v_num_equi 
    FROM equipos
     WHERE nombre = :NEW.nombre;
    IF v_num_equi > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'ERROR, EQUIPO YA EXISTENTE');
    END IF;
END equipo_duplicado_tr;
