INSERT INTO temporadas (ano, fecha_inicio_inscripcion, fecha_fin_inscripcion) VALUES (2024, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('30/06/2024', 'DD/MM/YYYY'));

SELECT COUNT(*) FROM registros_equipos where cod_temporada = 1;

INSERT INTO splits (cod_temporada, nombre, fecha_inicio, fecha_fin) VALUES (1, 'Split 1', TO_DATE('01/07/2024', 'DD/MM/YYYY'), TO_DATE('31/07/2024', 'DD/MM/YYYY'));



/*
Error starting at line : 3 in command -
INSERT INTO splits (cod_temporada, nombre, fecha_inicio, fecha_fin) VALUES (1, 'Split 1', TO_DATE('01/07/2024', 'DD/MM/YYYY'), TO_DATE('31/07/2024', 'DD/MM/YYYY'))
Error at Command Line : 3 Column : 13
Error report -
SQL Error: ORA-20001: Tiene que haber un minimo de 12 equipos para poder iniciar el split.
ORA-06512: at "HR.MIN_EQUIPOS", line 9
ORA-04088: error during execution of trigger 'HR.MIN_EQUIPOS'
*/

/*
Trigger

create or replace trigger min_equipos
before insert on splits
declare
    v_numero_equipos number;
begin
    select count(*) into v_numero_equipos from registros_equipos
    where cod_temporada = (select max(cod_temporada) from temporadas);
    
    if v_numero_equipos < 12
    then 
        raise_application_error(-20001, 'Tiene que haber un minimo de 12 equipos para poder iniciar el split.');
    end if;
end;

*/