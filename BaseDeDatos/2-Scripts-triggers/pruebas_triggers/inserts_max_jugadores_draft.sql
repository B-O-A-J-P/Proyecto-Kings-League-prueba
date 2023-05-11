select count(*) from contratos_equipo_jugador where cod_equipo = 0;


INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador', 'Apellido', 'Izquierdo', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO draft (cod_temporada, cod_jugador, posicion) VALUES (0, 96, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 10500000, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

/*
Error starting at line : 7 in command -
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 10500000, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'))
Error at Command Line : 7 Column : 13
Error report -
SQL Error: ORA-20001: El equipo ya tiene 8 jugadores pertenecientes al draft.
ORA-06512: at "HR.MAX_JUGADORES_DRAFT", line 19
ORA-04088: error during execution of trigger 'HR.MAX_JUGADORES_DRAFT'
*/

/*
Trigger

create or replace trigger max_jugadores_draft
before insert on contratos_equipo_jugador
for each row
declare
    v_numero_jugadores number;
    v_pertenece_draft number;
begin
    select count(*) into v_numero_jugadores
    from contratos_equipo_jugador cj, draft d
    where cj.cod_equipo = :new.cod_equipo 
    and cj.cod_jugador = d.cod_jugador --join
    and d.cod_temporada = (select max(cod_temporada) from temporadas)
    and (fecha_fin > sysdate or fecha_fin is null);
    
    select count(*) into v_pertenece_draft
    from draft 
    where cod_jugador = :new.cod_jugador
    and cod_temporada = (select max(cod_temporada) from temporadas);
    
    if v_numero_jugadores >= 8 and v_pertenece_draft > 0
    then 
        raise_application_error(-20001, 'El equipo ya tiene 8 jugadores pertenecientes al draft.');
    end if;
    
end max_jugadores_draft;

*/