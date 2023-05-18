CREATE OR REPLACE PACKAGE utilidades_base_kings_league AS
    procedure habilitar_desabilitar_trigger
    (p_op in varchar2);
END utilidades_base_kings_league;
