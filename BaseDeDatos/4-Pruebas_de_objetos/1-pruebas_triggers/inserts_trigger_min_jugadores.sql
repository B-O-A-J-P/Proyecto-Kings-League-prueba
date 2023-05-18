INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo 13', EMPTY_BLOB(), DEFAULT);

SELECT COUNT(*) FROM contratos_equipo_jugador where cod_equipo = 12;

INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 12);


/*
Error starting at line : 2 in command -
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 12)
Error at Command Line : 2 Column : 13
Error report -
SQL Error: ORA-20001: El equipo tiene que tener minimo 8 jugadores.
ORA-06512: at "HR.MIN_JUGADORES", line 12
ORA-04088: error during execution of trigger 'HR.MIN_JUGADORES'
*/

/*
Trigger
create or replace trigger min_jugadores
before insert on registros_equipos
for each row
declare
    v_numero_jugadores number;
begin
    
    select count(*) into v_numero_jugadores
    from contratos_equipo_jugador
    where cod_equipo = :new.cod_equipo
    and (fecha_fin > sysdate or fecha_fin is null);
    
    if (v_numero_jugadores < 8)
    then
        raise_application_error(-20001, 'El equipo tiene que tener minimo 8 jugadores.');
    end if;
    
end;
*/