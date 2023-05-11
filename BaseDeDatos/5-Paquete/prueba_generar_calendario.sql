INSERT INTO temporadas (ano, fecha_inicio_inscripcion, fecha_fin_inscripcion) VALUES (2022, TO_DATE('01/01/2022', 'DD/MM/YYYY'), TO_DATE('30/06/2022', 'DD/MM/YYYY'));

INSERT INTO splits (cod_temporada, nombre, fecha_inicio, fecha_fin) VALUES (0, 'Split 1', TO_DATE('01/07/2021', 'DD/MM/YYYY'), TO_DATE('31/07/2021', 'DD/MM/YYYY'));


INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo A', EMPTY_BLOB(), 1000000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo B', EMPTY_BLOB(), 1000000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo C', EMPTY_BLOB(), 750000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo D', EMPTY_BLOB(), 1250000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo E', EMPTY_BLOB(), 800000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo F', EMPTY_BLOB(), 950000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo G', EMPTY_BLOB(), 1100000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo H', EMPTY_BLOB(), 700000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo I', EMPTY_BLOB(), 900000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo J', EMPTY_BLOB(), 1200000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo K', EMPTY_BLOB(), 850000);
INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo L', EMPTY_BLOB(), 1050000);

INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 0);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 1);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 2);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 3);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 4);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 5);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 6);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 7);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 8);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 9);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 10);
INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 11);


/
DECLARE
BEGIN
 utilidades_calendario.generar_calendario(SYSDATE + 1, 'EN EL FIN DEL MUNDO', 0, 0);
END;