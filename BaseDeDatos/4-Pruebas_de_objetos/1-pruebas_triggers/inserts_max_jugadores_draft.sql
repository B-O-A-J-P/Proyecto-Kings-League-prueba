select count(*) from contratos_equipo_jugador where cod_equipo = 0;

--Prueba de inserts
INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('1111', 'Jugador', 'Apellido', 'Izquierdo', 180, 0);
INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, 96);
INSERT INTO draft (cod_temporada, cod_jugador, posicion) VALUES (0, 96, 96);
INSERT INTO contratos_equipo_jugador (cod_equipo, cod_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES (0, 96, 10500000, 10000000, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('31/12/2024', 'DD/MM/YYYY'));


--Prueba de update
select * from contratos_equipo_jugador;
update contratos_equipo_jugador set cod_equipo = 0 where cod_contrato = 8;
