set serveroutput on;
/*

INSERT INTO clasificaciones VALUES(0, 0, 1);
INSERT INTO clasificaciones VALUES(0, 1, 2);
INSERT INTO clasificaciones VALUES(0, 2, 3);
INSERT INTO clasificaciones VALUES(0, 3, 4);
INSERT INTO clasificaciones VALUES(0, 4, 5);
INSERT INTO clasificaciones VALUES(0, 5, 6);
INSERT INTO clasificaciones VALUES(0, 6, 7);
INSERT INTO clasificaciones VALUES(0, 7, 8);
INSERT INTO clasificaciones VALUES(0, 8, 9);
INSERT INTO clasificaciones VALUES(0, 9, 10);
INSERT INTO clasificaciones VALUES(0, 10, 11);
INSERT INTO clasificaciones VALUES(0, 11, 12);

*/

DECLARE
BEGIN
    utilidades_calendario.generar_playoff('12:00', 'EN EL FIN DEL MUNDO', 0);
END;