DECLARE
    out_ref_cursor SYS_REFCURSOR;
    v_cod_temporada temporadas.cod_temporada%type;
    v_codJugador jugadores.cod_jugador%type;
    v_nombreJugador jugadores.nombre%type;
    v_nombreApellido jugadores.apellido%type;
    v_codContrato contratos_equipo_jugador.cod_contrato%type;
    v_clausula contratos_equipo_jugador.clausula%type;
    v_salario contratos_equipo_jugador.salario%type;
    v_codEquipo contratos_equipo_jugador.cod_equipo%type;
    v_nombreEquipo equipos.nombre%type;
BEGIN
    informe_jugador_ultima_temporada(10, out_cursor => out_ref_cursor);
    DBMS_OUTPUT.PUT_LINE('COD_JUGADOR | NOMBRE | APELLIDO | COD_CONTRATO | CLAUSULA | SALARIO | COD_EQUIPO | NOMBRE_EQUIPO');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------------------------------');
    LOOP
        FETCH out_ref_cursor INTO v_codJugador, v_nombreJugador, v_nombreApellido, v_codContrato, v_clausula, v_salario, v_codEquipo, v_nombreEquipo;
        EXIT WHEN out_ref_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(
            'Código de jugador: ' || v_codJugador || ' || ' ||
            'Nombre de jugador: ' || v_nombreJugador || ' ' || v_nombreApellido ||
            'Código contrato: ' || v_codContrato || ' || ' ||
            'Clausula: ' || v_clausula || ' || ' ||
            'Salario: ' || v_salario || ' || ' ||
            'Código equipo: ' || v_codEquipo || ' || ' ||
            'Nombre equipo: ' || v_nombreEquipo 
        );
    END LOOP;
    CLOSE out_ref_cursor;
END;