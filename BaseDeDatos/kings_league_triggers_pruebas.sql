





--Prueba del trigger max_presupuesto_equipo
--Insertamos un contrato donde la clausula es tan grande que con la suma de los
--jugadores supere los 200M
insert into contratos_equipo_jugador
values(0,4,default,10000000,99999999,sysdate,sysdate+2);
/*RESULTADO OBTENIDO
Error que empieza en la línea: 28 del comando :
insert into contratos_equipo_jugador
values(0,4,default,10000000,99999999,sysdate,sysdate+2)
Informe de error -
ORA-20001: no puede sobrepasarse el presupuesto establecido
ORA-06512: en "HR.MAX_PRESUPUESTO_EQUIPO", línea 17
ORA-04088: error durante la ejecución del disparador 'HR.MAX_PRESUPUESTO_EQUIPO'
*/


--Prueba trigger check_contrato_jugador_split
--para comprobar este trigger, insertamos un contrato donde el jugador ya tenga uno
insert into contratos_equipo_jugador values (0,0,default,10000000,99000000,'04/05/23','06/05/23');
/*Resultado obtenido
Error que empieza en la línea: 19 del comando :
insert into contratos_equipo_jugador values (0,0,default,10000000,99000000,'04/05/23','06/05/23')
Informe de error -
ORA-20001: Este jugador ya tiene un contrato activo
ORA-06512: en "HR.CHECK_CONTRATO_JUGADOR_SPLIT", línea 12
ORA-04088: error durante la ejecución del disparador 'HR.CHECK_CONTRATO_JUGADOR_SPLIT'
*/
