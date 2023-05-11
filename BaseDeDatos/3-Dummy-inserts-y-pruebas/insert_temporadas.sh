#!/bin/bash

rm ./insert_temporadas.sql 2>/dev/null
echo "INSERT INTO jugadores (dni, nombre, apellido, pie, altura, cod_agenda) VALUES ('12345678A', 'Jugador', 'Uno', 'Izquierdo', 180, 0);" >> insert_temporadas.sql

for i in {0..10}
do
    echo "INSERT INTO temporadas(ano, fecha_inicio_inscripcion, fecha_fin_inscripcion) values(2023, SYSDATE + $i, SYSDATE + $i + 1);" >> insert_temporadas.sql
done

for h in {0..95}
do
    echo "INSERT INTO agendas (email, telefono) VALUES ('example@example.com', '123456789');" >> insert_temporadas.sql
    echo "INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDO,PIE,ALTURA, cod_agenda) VALUES('$h','nombre$h','apellido$h','DERECHO',174, $h);" >> insert_temporadas.sql
    echo "INSERT INTO registros_jugadores (cod_temporada, cod_jugador) VALUES (0, $h);" >> insert_temporadas.sql
    echo "INSERT INTO draft (cod_temporada, cod_jugador, posicion) VALUES (0, $h, $h);" >> insert_temporadas.sql
done

x=0

for y in {0..11}
do
    echo "INSERT INTO EQUIPOS(NOMBRE, PRESUPUESTO) VALUES('PORCINOS',200000000);" >> insert_temporadas.sql
    for m in {0..7}
    do
        echo "INSERT INTO contratos_equipo_jugador (id_equipo, id_jugador, salario, clausula, fecha_inicio, fecha_fin) VALUES ($y, $x, 10500000, 10000000, TO_DATE('01/01/2023', 'DD/MM/YYYY'), TO_DATE('31/12/2023', 'DD/MM/YYYY'));" >> insert_temporadas.sql
        x=$((x+1))
    done
done


