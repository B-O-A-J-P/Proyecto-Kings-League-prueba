set serveroutput on;

DECLARE
BEGIN
    utilidades_calendario.generar_playoff('12:00', 'PLAY OFF', 0);
END;

/*
SELECT * FROM jornadas;
*/