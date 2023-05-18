SET SERVEROUTPUT ON;
----------¡¡¡¡ES NECESARIO EJECUTAR UNO DE LOS DOS COMENTARIOS!!!!--------------

/*
--MAC
@"$HOME/Documents/Proyecto-Kings-League/BaseDeDatos/3-Dummy_inserts/dummy-inserts-informacion-partidos.sql"
*/

/*
--WINDOWS
@\%USERPROFILE%\Documents\Proyecto-Kings-League\BaseDeDatos\3-Dummy_inserts\dummy-inserts-informacion-partidos.sql
*/

/
BEGIN
    utilidades_calendario.calcularClasificacion(0);
END;
/

/*
select * from informacion_partidos;
select * from clasificaciones;
*/