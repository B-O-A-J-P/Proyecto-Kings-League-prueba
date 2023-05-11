SELECT SUM(salario + clausula) FROM contratos_equipo_jugador WHERE cod_equipo = 0 AND (fecha_fin > sysdate OR fecha_fin IS NULL);

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador1111', 'Apellido1111', 'Izquierdo1111', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 999999999, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));



/*
Error starting at line : 6 in command -
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 999999999, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'))
Error at Command Line : 6 Column : 13
Error report -
SQL Error: ORA-20001: No se puede sobrepasar el presupuesto del equipo.
ORA-06512: at "HR.MAX_PRESUPUESTO_EQUIPO", line 18
ORA-04088: error during execution of trigger 'HR.MAX_PRESUPUESTO_EQUIPO'
*/

/*
Trigger

CREATE OR REPLACE TRIGGER max_presupuesto_equipo
before INSERT OR UPDATE on contratos_equipo_jugador
for each row
declare
    v_dinero_total number;
    v_presupuesto_maximo number;
  BEGIN
    SELECT presupuesto INTO v_presupuesto_maximo
    FROM equipos
    WHERE cod_equipo = :new.cod_equipo;
            
    SELECT SUM(salario + clausula) INTO v_dinero_total
    FROM contratos_equipo_jugador
    WHERE cod_equipo = :new.cod_equipo
    AND (fecha_fin > sysdate OR fecha_fin IS NULL);
    
    v_dinero_total := v_dinero_total + :new.salario + :new.clausula;
    
    if v_dinero_total > v_presupuesto_maximo
    then
       raise_application_error(-20001, 'No se puede sobrepasar el presupuesto del equipo.');
    end if;

END max_presupuesto_equipo;
*/