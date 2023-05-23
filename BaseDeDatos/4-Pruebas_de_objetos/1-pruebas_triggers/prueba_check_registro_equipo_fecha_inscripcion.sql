--SELECT * FROM TEMPORADAS;
--SELECT * FROM REGISTROS_EQUIPOS;

ALTER TRIGGER TRIGGER_TEMPORADAS_ANO DISABLE;
insert into temporadas values(default, 2022, sysdate - 365, sysdate - 335);
INSERT INTO registros_equipos values(1, 0);

update registros_equipos set cod_temporada = 1 where cod_equipo = 0;