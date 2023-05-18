INSERT INTO equipos (nombre, logo, presupuesto) VALUES ('Equipo 13', EMPTY_BLOB(), DEFAULT);

--Prueba inserts
SELECT COUNT(*) FROM contratos_equipo_jugador where cod_equipo = 12;

INSERT INTO registros_equipos (cod_temporada, cod_equipo) VALUES (0, 12);


--Prueba updates
SELECT * FROM registros_equipos;
SELECT * FROM contratos_equipo_jugador;
update contratos_equipo_jugador set cod_equipo = 1 where cod_contrato = 0;