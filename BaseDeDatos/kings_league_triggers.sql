
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
    codEquipo contratos_equipo_jugador.cod_equipo%type := :new.cod_equipo;
    numeroContratos number;
begin
    select count(*) into numeroContratos
    from contratos_equipo_jugador cj, draft d
    where cod_equipo = codEquipo 
    and cj.cod_jugador = d.cod_jugador 
    and d.cod_temporada = (select max(cod_temporada) from draft)
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if numeroContratos > 8
    then 
        raise_application_error(-20001, 'El equipo ya tiene 8 jugadores');
    end if;
    
end max_jugadores;

/

create or replace trigger max_jugadores_wild_card
before insert on contratos_equipo_jugador
for each row
declare
    codEquipo contratos_equipo_jugador.cod_equipo%type := :new.cod_equipo;
    numeroContratos number;
begin
    select count(*) into numeroContratos
    from contratos_equipo_jugador cj
    where cod_equipo = codEquipo 
    and cj.cod_jugador not in (select cod_jugador from draft where cod_temporada = (select max(cod_temporada) from draft))
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if numeroContratos > 2
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

