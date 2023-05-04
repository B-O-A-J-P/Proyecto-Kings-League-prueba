CREATE OR REPLACE PACKAGE  utilidades_calendario AS
 	PROCEDURE procedure_attempt_two
    (p_cod_temporada IN temporadas.cod_temporada%TYPE,
     p_cod_split IN splits.cod_split%TYPE,
     out_cursor OUT SYS_REFCURSOR);

	procedure habilitar_desabilitar_trigger
	(p_op in varchar2);
    
END utilidades_calendario;
