set serveroutput on;

DECLARE
BEGIN
    utilidades_calendario.generar_playoff('12:00', 'PLAY OFF', 0);
END;

/*
SELECT * FROM jornadas;

SELECT * FROM partidos 
where cod_jornada = (select max(cod_jornada) from jornadas);

*/
