--select * from jugadores;
--select * from temporadas;
--select * from registros_jugadores;
insert into temporadas values(default, 2024, TO_DATE('10/06/2024', 'DD/MM/YYYY'), TO_DATE('10/08/2024', 'DD/MM/YYYY'));
insert into temporadas values(default, 2024, TO_DATE('10/02/2024', 'DD/MM/YYYY'), TO_DATE('10/04/2024', 'DD/MM/YYYY'));
insert into jugadores values(default, 'testing12', 'testing1234', 'testing1234', 'izquierdo', 180, 0);
insert into registros_jugadores values(1, 96);
insert into registros_jugadores values(2, 96);

update registros_jugadores set cod_temporada = 1 where cod_jugador = 0;