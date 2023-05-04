
drop trigger max_jugadores;
drop trigger min_jugadores;
drop trigger max_presupuesto_equipo;
drop trigger min_clausula_inicial;


--maximo de jugadores:

create or replace trigger max_jugadores
	before insert on jugadores
	for each row
		declare
			v_num_jug number;
		begin
			select count(*) into v_num_jug
			from jugadores;

			if v_num_jug > 10 then
				raise_application_error(-20001, 'No puede haber mas de 10 jugadores en un equipo');
			end if;
end max_jugadores;

--minimo de jugadores:

--error tabla no existe
create or replace trigger min_jugadores
	before insert on calendario_jornada
	for each row
		declare
			v_num_jugadores number;
		begin
			select count(*) into v_num_jugadores
			from jugadores;

			if v_num_jugadores < 8 then
				raise_application_error(-20002, 'Para generar el calendario, deben haber como minimo 8 jugadores');
			end if;
end min_jugadores;

-- controlar presupuesto equipo

create or replace trigger max_presupuesto_equipo
	before insert or update on contratos_equipo_jugador
	for each row
	DECLARE
		v_pres_max number;
		begin
			select sum(clausula) into v_pres_max
			from contratos_equipo_jugador
			where cod_equipo = :new.cod_equipo;

			if v_pres_max > 200000000 then
				raise_application_error(-20003, 'El presupuesto maximo es de 200.000.000');
			end if;
end max_presupuesto_equipo;



-- controlar clausula inicial

create or replace trigger min_clausula_inicial
	before insert or update on contratos_equipo_jugador
	for each row
		begin
			if :new.clausula < 1000000 then
				raise_application_error(-20004, 'La clausula minima inicial es de 1.000.000');
			end if;
end min_clausula_inicial;

--
--error
CREATE OR REPLACE TRIGGER tr_calendario
BEFORE UPDATE ON EQUIPOS OR 
BEFORE UPDATE ON JUGADORES
FOR EACH ROW
DECLARE
    V_NUM NUMBER;
BEGIN
	SELECT COUNT(*) INTO V_NUM
	FROM calendario_jornada;

	IF V_NUM > 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'No se pueden actualizar las tablas equipos ni jugadores, despues de generar el calendario');
        END IF;
    END IF;

