SELECT COUNT(*) FROM contratos_equipo_jugador where cod_jugador not in (select cod_jugador from draft) and cod_equipo = 0;

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador1111', 'Apellido1111', 'Izquierdo1111', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('2222', 'Jugador2222', 'Apellido2222', 'Izquierdo2222', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 97);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 97, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('3333', 'Jugador3333', 'Apellido3333', 'Izquierdo3333', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 98);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 98, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));



/*
Error starting at line : 13 in command -
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 98, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'))
Error at Command Line : 13 Column : 13
Error report -
SQL Error: ORA-20001: El equipo ya tiene 2 jugadores wild card.
ORA-06512: at "HR.MAX_JUGADORES_WILD_CARD", line 13
ORA-04088: error during execution of trigger 'HR.MAX_JUGADORES_WILD_CARD'
*/

/*
Trigger

create or replace trigger max_jugadores_wild_card
before insert on contratos_equipo_jugador
for each row
declare
    v_numero_jugadores number;
begin
    select count(*) into v_numero_jugadores
    from contratos_equipo_jugador cj, registros_jugadores rj
    where cj.cod_equipo = :new.cod_equipo 
    and cj.cod_jugador = rj.cod_jugador
    and rj.cod_jugador not in (select cod_jugador from draft where cod_temporada = (select max(cod_temporada) from temporadas))
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if v_numero_jugadores >= 2
    then 
        raise_application_error(-20001, 'El equipo ya tiene 2 jugadores wild card.');
    end if;
    
end max_jugadores_wild_card;

*/