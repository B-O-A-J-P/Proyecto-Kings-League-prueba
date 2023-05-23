INSERT INTO temporadas (ano, fecha_inicio_inscripcion, fecha_fin_inscripcion) VALUES (2024, TO_DATE('01/01/2024', 'DD/MM/YYYY'), TO_DATE('30/06/2024', 'DD/MM/YYYY'));

--Prueba insert
--SELECT COUNT(*) FROM registros_equipos where cod_temporada = 1;

INSERT INTO splits (cod_temporada, nombre, fecha_inicio, fecha_fin) VALUES (1, 'Split 1', TO_DATE('01/07/2024', 'DD/MM/YYYY'), TO_DATE('31/07/2024', 'DD/MM/YYYY'));

--Prueba update
--select * from splits;
update splits set cod_temporada = 0 where cod_split = 0;