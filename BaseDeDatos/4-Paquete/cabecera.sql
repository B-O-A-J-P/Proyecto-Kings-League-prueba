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

	PROCEDURE habilitar_desabilitar_trigger
	(p_op in varchar2);
    
END utilidades_calendario;
