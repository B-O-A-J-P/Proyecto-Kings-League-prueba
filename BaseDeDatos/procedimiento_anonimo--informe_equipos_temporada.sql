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
    informe_equipos_temporada(10, out_cursor => mi_cursor);
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
