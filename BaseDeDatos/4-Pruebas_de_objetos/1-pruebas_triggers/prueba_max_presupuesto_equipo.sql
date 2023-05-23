--SELECT SUM(salario + clausula) FROM contratos_equipo_jugador WHERE cod_equipo = 0 AND (fecha_fin > sysdate OR fecha_fin IS NULL);
--Pruebas inserts
--alter table contratos_equipo_jugador disable CONSTRAINT CON_SAL_CK;
INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador1111', 'Apellido1111', 'Izquierdo1111', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 22500000, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('2222', 'Jugador1111', 'Apellido1111', 'Izquierdo1111', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 97);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 97, 22500000, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));

--Pruebas update
--select * from contratos_equipo_jugador;
update contratos_equipo_jugador set cod_equipo = 0 where cod_equipo > 0;

update contratos_equipo_jugador set clausula = (3500000 + 10000001) where cod_contrato = 96;