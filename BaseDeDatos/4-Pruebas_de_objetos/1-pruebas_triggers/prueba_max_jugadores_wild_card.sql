--SELECT COUNT(*) FROM contratos_equipo_jugador where cod_jugador not in (select cod_jugador from draft) and cod_equipo = 0;

--Prueba inserts
INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador1111', 'Apellido1111', 'Izquierdo1111', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('2222', 'Jugador2222', 'Apellido2222', 'Izquierdo2222', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 97);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 97, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('3333', 'Jugador3333', 'Apellido3333', 'Izquierdo3333', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 98);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 98, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

--Prueba update
--SELECT COUNT(*) FROM contratos_equipo_jugador where cod_jugador not in (select cod_jugador from draft) and cod_equipo = 0;
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (1, 98, 10500000, 1000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

--select * from contratos_equipo_jugador where cod_equipo = 1 and cod_jugador = 98;
update contratos_equipo_jugador set cod_equipo = 0 where cod_contrato = 99;
