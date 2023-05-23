SET SERVEROUTPUT ON;
DECLARE
    mi_cursor SYS_REFCURSOR;
    codEquipo equipos.cod_equipo%type;
    nombre equipos.nombre%type;
    presupuesto equipos.presupuesto%type;
    numeroJugadores NUMBER;
    codPresidente miembros.cod_miembro%type;    
    nombrePresidente VARCHAR2(100);
    fechaInicioPresidencia DATE;
    codEntrenador miembros.cod_miembro%type;    
    nombreEntrenador VARCHAR2(100);
    codStaff miembros.cod_miembro%type;    
    nombreStaff VARCHAR2(100);
BEGIN
    informe_equipos_temporada(0, out_cursor => mi_cursor);
    LOOP
        FETCH mi_cursor INTO codEquipo, nombre, presupuesto, numeroJugadores, codPresidente, 
        nombrePresidente, fechaInicioPresidencia, codEntrenador, nombreEntrenador, codStaff, nombreStaff;
        EXIT WHEN mi_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(
        'Código de equipo: ' || codEquipo || ' || ' || 
        'Nombre de equipo: ' || nombre || ' || ' || 
        'Presupuesto de equipo: ' || presupuesto || ' || ' ||
        'Código de presidente: ' || codPresidente || ' || ' ||
        'Presidente: ' || INITCAP(nombrePresidente) || ' (desde ' || fechaInicioPresidencia || ')' || ' || ' ||
        'Código de entrenador: ' || codEntrenador || ' || ' ||
        'Entrenador: ' || INITCAP(nombreEntrenador) || ' || ' ||
        'Código de staff: ' || codStaff || ' || ' ||
        'Staff: ' || INITCAP(nombreStaff) || ' || ' || 
        'Número de jugadores: ' || numeroJugadores);
    END LOOP;
    CLOSE mi_cursor;
END;

/*
Código de equipo: 0 || Nombre de equipo: Equipo 1 || Presupuesto de equipo: 200000000 || Código de presidente: 0 || Presidente: Miembro 0 Apellido (desde 01-JAN-22) || Código de entrenador: 24 || Entrenador: Miembro 8 Apellido || Código de staff: 12 || Staff: Miembro 4 Apellido || Número de jugadores: 8
Código de equipo: 1 || Nombre de equipo: Equipo 2 || Presupuesto de equipo: 200000000 || Código de presidente: 1 || Presidente: Miembro 12 Apellido (desde 01-JAN-22) || Código de entrenador: 25 || Entrenador: Miembro 20 Apellido || Código de staff: 13 || Staff: Miembro 16 Apellido || Número de jugadores: 8
Código de equipo: 2 || Nombre de equipo: Equipo 3 || Presupuesto de equipo: 200000000 || Código de presidente: 2 || Presidente: Miembro 24 Apellido (desde 01-JAN-22) || Código de entrenador: 26 || Entrenador: Miembro 32 Apellido || Código de staff: 14 || Staff: Miembro 28 Apellido || Número de jugadores: 8
Código de equipo: 3 || Nombre de equipo: Equipo 4 || Presupuesto de equipo: 200000000 || Código de presidente: 3 || Presidente: Miembro 1 Apellido (desde 01-JAN-22) || Código de entrenador: 27 || Entrenador: Miembro 9 Apellido || Código de staff: 15 || Staff: Miembro 5 Apellido || Número de jugadores: 8
Código de equipo: 4 || Nombre de equipo: Equipo 5 || Presupuesto de equipo: 200000000 || Código de presidente: 4 || Presidente: Miembro 13 Apellido (desde 01-JAN-22) || Código de entrenador: 28 || Entrenador: Miembro 21 Apellido || Código de staff: 16 || Staff: Miembro 17 Apellido || Número de jugadores: 8
Código de equipo: 5 || Nombre de equipo: Equipo 6 || Presupuesto de equipo: 200000000 || Código de presidente: 5 || Presidente: Miembro 25 Apellido (desde 01-JAN-22) || Código de entrenador: 29 || Entrenador: Miembro 33 Apellido || Código de staff: 17 || Staff: Miembro 29 Apellido || Número de jugadores: 8
Código de equipo: 6 || Nombre de equipo: Equipo 7 || Presupuesto de equipo: 200000000 || Código de presidente: 6 || Presidente: Miembro 2 Apellido (desde 01-JAN-22) || Código de entrenador: 30 || Entrenador: Miembro 10 Apellido || Código de staff: 18 || Staff: Miembro 6 Apellido || Número de jugadores: 8
Código de equipo: 7 || Nombre de equipo: Equipo 8 || Presupuesto de equipo: 200000000 || Código de presidente: 7 || Presidente: Miembro 14 Apellido (desde 01-JAN-22) || Código de entrenador: 31 || Entrenador: Miembro 22 Apellido || Código de staff: 19 || Staff: Miembro 18 Apellido || Número de jugadores: 8
Código de equipo: 8 || Nombre de equipo: Equipo 9 || Presupuesto de equipo: 200000000 || Código de presidente: 8 || Presidente: Miembro 26 Apellido (desde 01-JAN-22) || Código de entrenador: 32 || Entrenador: Miembro 34 Apellido || Código de staff: 20 || Staff: Miembro 30 Apellido || Número de jugadores: 8
Código de equipo: 9 || Nombre de equipo: Equipo 10 || Presupuesto de equipo: 200000000 || Código de presidente: 9 || Presidente: Miembro 3 Apellido (desde 01-JAN-22) || Código de entrenador: 33 || Entrenador: Miembro 11 Apellido || Código de staff: 21 || Staff: Miembro 7 Apellido || Número de jugadores: 8
Código de equipo: 10 || Nombre de equipo: Equipo 11 || Presupuesto de equipo: 200000000 || Código de presidente: 10 || Presidente: Miembro 15 Apellido (desde 01-JAN-22) || Código de entrenador: 34 || Entrenador: Miembro 23 Apellido || Código de staff: 22 || Staff: Miembro 19 Apellido || Número de jugadores: 8
Código de equipo: 11 || Nombre de equipo: Equipo 12 || Presupuesto de equipo: 200000000 || Código de presidente: 11 || Presidente: Miembro 27 Apellido (desde 01-JAN-22) || Código de entrenador: 35 || Entrenador: Miembro 35 Apellido || Código de staff: 23 || Staff: Miembro 31 Apellido || Número de jugadores: 8
Código de equipo: 12 || Nombre de equipo: Equipo 13 || Presupuesto de equipo: 200000000 || Código de presidente:  || Presidente:   (desde ) || Código de entrenador:  || Entrenador:   || Código de staff:  || Staff:   || Número de jugadores: 0

PL/SQL procedure successfully completed.
*/
