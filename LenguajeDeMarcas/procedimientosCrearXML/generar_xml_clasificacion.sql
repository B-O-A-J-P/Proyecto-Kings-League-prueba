--CREAR TABLA: 
CREATE TABLE clasificacion(result CLOB);


DROP TYPE equipo_tipo FORCE;
DROP TYPE equipolist_tipo FORCE;
DROP TYPE clasificacion_tipo FORCE;
DROP TYPE split_tipo FORCE;
DROP TYPE splitlist_tipo FORCE;
DROP TYPE temporada_tipo FORCE;

CREATE OR REPLACE TYPE equipo_tipo AS OBJECT (
"@ID" NUMBER(5),
nombre VARCHAR2(50),
logo BLOB,
puntos NUMBER(3),
goles NUMBER(2)
);
/
CREATE OR REPLACE TYPE equipolist_tipo AS TABLE OF equipo_tipo;
/
CREATE OR REPLACE TYPE clasificacion_tipo AS OBJECT (
"@fecha_fin" DATE,
equipo equipolist_tipo
);
/
CREATE OR REPLACE TYPE clasificacion_list AS TABLE OF clasificacion_tipo;
/

CREATE OR REPLACE TYPE split_tipo AS OBJECT (
"@ID" NUMBER(5),
clasificacion clasificacion_tipo
);
/
CREATE OR REPLACE TYPE splitlist_tipo AS TABLE OF split_tipo;

/
CREATE OR REPLACE TYPE temporada_tipo AS OBJECT (
"@ID" NUMBER(5),
split splitlist_tipo
);
/
DECLARE
    resultado CLOB;
    qryCtx DBMS_XMLGEN.ctxHandle;
BEGIN
    qryCtx := DBMS_XMLGEN.newContext('
        SELECT temporada_tipo(
            t.cod_temporada,
            CAST(
                MULTISET(
                    SELECT split_tipo(
                        s.cod_split,
                        clasificacion_tipo(
                            s.fecha_fin,
                            CAST(
                                MULTISET(
                                    SELECT
                                        equipo_tipo(
                                            e.cod_equipo,
                                            e.nombre,
                                            e.logo,
                                            (SELECT COUNT(*) FROM informacion_partidos ip WHERE ip.cod_partido IN (SELECT cod_partido FROM partidos WHERE cod_equipo1 = e.cod_equipo) AND ip.cod_equipo = e.cod_equipo AND ip.resultado = ''v''),
                                            (SELECT SUM(ip.numero_goles) FROM informacion_partidos ip WHERE ip.cod_partido IN (SELECT cod_partido FROM partidos WHERE cod_equipo1 = e.cod_equipo) AND ip.cod_equipo = e.cod_equipo)
                                        )
                                    FROM equipos e
                                    JOIN clasificaciones c ON e.cod_equipo = c.cod_equipo
                                    WHERE c.cod_split = s.cod_split
                                    ORDER BY c.posicion
                                ) AS equipolist_tipo
                            )
                        ))
                    FROM splits s
                    WHERE s.cod_temporada = t.cod_temporada
                    ORDER BY s.cod_split ASC
                ) AS splitlist_tipo)
            
        ) as "temporada"
        FROM temporadas t
        WHERE t.cod_temporada = 0'
    );
    
    dbms_xmlgen.setRowTag(qryCtx, NULL);
    dbms_xmlgen.setRowSetTag(qryCtx, NULL);
    DBMS_XMLGEN.setNullHandling(qryCtx, 2);
    
    resultado := DBMS_XMLGEN.getXML(qryCtx);
    
    INSERT INTO clasificacion VALUES (resultado);
    
    DBMS_XMLGEN.closeContext(qryCtx);
END;

