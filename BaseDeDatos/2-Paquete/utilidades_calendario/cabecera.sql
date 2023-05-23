CREATE OR REPLACE PACKAGE utilidades_calendario AS
 	PROCEDURE generar_calendario
    (p_hora_inicio IN varchar2,
     p_ubicacion IN varchar2,
     p_cod_split IN splits.cod_split%TYPE);

    PROCEDURE generar_playoff
    (p_hora_inicio IN varchar2,
     p_ubicacion IN varchar2,
     p_cod_split IN splits.cod_split%type);
     
     PROCEDURE calcularClasificacion
    (p_cod_split splits.cod_split%type);
END utilidades_calendario;
