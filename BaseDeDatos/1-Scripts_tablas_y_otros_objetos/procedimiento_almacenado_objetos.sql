--Uso: su único uso es complementar el informe_equipos_temporada
CREATE OR REPLACE FUNCTION contar_numero_jugadores_por_equipo
    (p_cod_equipo IN equipos.cod_equipo%type,
    p_cod_temporada IN temporadas.cod_temporada%type)
    RETURN NUMBER
is
    v_num_jugadores NUMBER;
begin

    SELECT count(*) into v_num_jugadores
    FROM temporadas t
    JOIN registros_equipos re ON t.cod_temporada = re.cod_temporada
    JOIN equipos e ON re.cod_equipo = e.cod_equipo AND re.cod_equipo = p_cod_equipo
    JOIN contratos_equipo_jugador cj ON e.cod_equipo = cj.cod_equipo AND EXTRACT(YEAR FROM cj.fecha_inicio) = t.ano
    JOIN draft d ON cj.cod_jugador = d.cod_jugador AND re.cod_temporada = d.cod_temporada
    WHERE t.cod_temporada = p_cod_temporada;

    
    return v_num_jugadores;
    
end contar_numero_jugadores_por_equipo;
/

--------------------------------------------------------------------------------

--Informe de equipo
--Uso: dar un informe a los administradores
CREATE OR REPLACE PROCEDURE informe_equipos_temporada 
    (p_cod_temporada IN temporadas.cod_temporada%type,
    out_cursor OUT SYS_REFCURSOR)
AS
    v_verificar_temporada NUMBER;
    
    temporada_no_encontrada EXCEPTION;
BEGIN

    SELECT COUNT(*) INTO v_verificar_temporada FROM temporadas WHERE cod_temporada = p_cod_temporada;
    
    IF (v_verificar_temporada = 0) 
    THEN
        RAISE_APPLICATION_ERROR(-20001, 'Temporada no encontrada');
    END IF;

    OPEN out_cursor FOR
        SELECT e.cod_equipo AS "Código del equipo",
       e.nombre AS "Nombre del equipo",
       e.presupuesto AS "Presupuesto del equipo",
       contar_numero_jugadores_por_equipo(e.cod_equipo, p_cod_temporada) AS "Número de jugadores",
       p.cod_miembro AS cod_presidente,
       p.nombre || ' ' || p.apellido AS nombre_presidente,
       p.fecha_entrada AS "Presidente desde",
       en.cod_miembro AS cod_entrenador,
       en.nombre || ' ' || en.apellido AS nombre_entrenador,
       s.cod_miembro AS cod_staff,
       s.nombre || ' ' || s.apellido AS nombre_staff
    FROM equipos e
    JOIN registros_equipos ep ON e.cod_equipo = ep.cod_equipo AND ep.cod_temporada = p_cod_temporada
    JOIN presidentes_equipos p ON e.cod_equipo = p.cod_equipo
    JOIN entrenadores_equipos en ON e.cod_equipo = en.cod_equipo
    JOIN staffs_equipos s ON e.cod_equipo = s.cod_equipo;
END informe_equipos_temporada;
/

--informe de jugador
CREATE OR REPLACE PROCEDURE informe_jugador_ultima_temporada
    (p_cod_temporada IN temporadas.cod_temporada%type,
    out_cursor OUT SYS_REFCURSOR)
as
    v_cod_temporada temporadas.cod_temporada%type;
    v_verificar_temporada NUMBER;
    
    temporada_no_encontrada EXCEPTION;
begin

    SELECT COUNT(*) INTO v_verificar_temporada FROM temporadas WHERE cod_temporada = p_cod_temporada;
    
    IF (v_verificar_temporada = 0) 
    THEN
        RAISE_APPLICATION_ERROR(-20001, 'Temporada no encontrada');
    END IF;

    select max(cod_temporada) into v_cod_temporada
    from temporadas
    where ano = (select max(ano) from temporadas);
    
    open out_cursor for
        select j.cod_jugador, j.nombre, j.apellido, cj.cod_contrato, cj.clausula, cj.salario, cj.cod_equipo, e.nombre
        from jugadores j, draft d, contratos_equipo_jugador cj, equipos e
        where j.cod_jugador = d.cod_jugador
        and j.cod_jugador = cj.cod_jugador
        and cj.cod_equipo = e.cod_equipo
        and EXTRACT(YEAR FROM fecha_inicio) = (select ano from temporadas where cod_temporada = p_cod_temporada);
    
end informe_jugador_ultima_temporada;

/

--------------------------------------------------------------------------------

--Uso: por ahora, se utiliza en el trigger max_jugadores_draft
CREATE OR REPLACE FUNCTION get_numero_jugadores_draft(
    p_cod_equipo IN contratos_equipo_jugador.cod_equipo%TYPE
) RETURN NUMBER AS
    v_numero_jugadores NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_numero_jugadores
    FROM contratos_equipo_jugador cj
    JOIN draft d ON cj.cod_jugador = d.cod_jugador
    WHERE cj.cod_equipo = p_cod_equipo
        AND d.cod_temporada = (SELECT MAX(cod_temporada) FROM temporadas)
        AND (cj.fecha_fin > SYSDATE OR cj.fecha_fin IS NULL);
    
    RETURN v_numero_jugadores;
END;


