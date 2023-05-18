--CREAR TABLA: 
CREATE TABLE CALENDARIO_JORNADAS(result CLOB);

--

DROP TYPE Equipos_xml FORCE;
drop type equipolist_tipo force;
DROP TYPE Partidos_xml FORCE;
DROP TYPE Jornadas_xml FORCE;
DROP TYPE Splits_xml FORCE;
DROP TYPE jornadalist_tipo FORCE;
DROP TYPE splitlist_tipo FORCE;
DROP TYPE temporada_tipo FORCE;

CREATE OR REPLACE TYPE Equipos_xml AS OBJECT (
"@ID" NUMBER(5),
nombre VARCHAR2(50),
logo BLOB
);
/

CREATE OR REPLACE TYPE equipolist_tipo AS TABLE OF Equipos_xml;
/
CREATE OR REPLACE TYPE Partidos_xml AS OBJECT (
"@ID" NUMBER(5),
hora VARCHAR2(20),
equipo_local Equipos_xml,
equipo_visitante Equipos_xml
);
/
CREATE OR REPLACE TYPE partidolist_tipo AS TABLE OF Partidos_xml;
/
CREATE OR REPLACE TYPE Jornadas_xml AS OBJECT (
"@ID" NUMBER(5),
fecha DATE,
partido partidolist_tipo
);
/

CREATE OR REPLACE TYPE jornadalist_tipo AS TABLE OF Jornadas_xml;
/
CREATE OR REPLACE TYPE Splits_xml AS OBJECT (
"@ID" NUMBER(5),
fecha_inicio date,
fecha_fin date,
jornada jornadalist_tipo
);
/
CREATE OR REPLACE TYPE splitlist_tipo AS TABLE OF Splits_xml;
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
        SELECT 
        s.cod_split,
        s.fecha_inicio,
        s.fecha_fin,
        CAST(
        MULTISET(
        SELECT 
        j.cod_jornada,
        j.fecha,
        CAST(
        MULTISET(
        SELECT 
        p.cod_partido,
        TO_CHAR(p.hora, ''YYYY-MM-DD"T"HH24:MI:SS''),
        Equipos_xml(
        e1.cod_equipo,
        e1.nombre,
        e1.logo
        ),
        Equipos_xml(
        e2.cod_equipo,
        e2.nombre,
        e2.logo
        )
        
        FROM partidos p
        JOIN equipos e1 ON p.cod_equipo1 = e1.cod_equipo
        JOIN equipos e2 ON p.cod_equipo2 = e2.cod_equipo
        WHERE p.cod_jornada = j.cod_jornada
        ORDER BY p.cod_partido ASC
        ) AS partidolist_tipo
        )
        
        FROM jornadas j
        WHERE j.cod_split = s.cod_split
        ORDER BY j.cod_jornada ASC
        ) AS jornadalist_tipo
        )
        
        FROM splits s
        WHERE s.cod_temporada = t.cod_temporada
        ORDER BY s.cod_split ASC
        ) AS splitlist_tipo
        ))
        as "temporada"
        FROM temporadas t
        WHERE t.cod_temporada = 0');
        
        
        dbms_xmlgen.setRowTag( qryCtx, NULL );
   
        dbms_xmlgen.setRowSetTag( qryCtx, NULL );
   
        DBMS_XMLGEN.setNullHandling(qryCtx, 2);


        resultado := DBMS_XMLGEN.getXML(qryCtx);

        INSERT INTO CALENDARIO_JORNADAS VALUES (resultado);

        DBMS_XMLGEN.closeContext(qryCtx); 
END;
