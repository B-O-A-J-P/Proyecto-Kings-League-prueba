CREATE OR REPLACE PACKAGE BODY utilidades_base_kings_league AS
--------------------------------------------------------------------------------
procedure habilitar_desabilitar_trigger
(p_op in varchar2) as
begin

    if p_op = 'habilitar' then
    
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_splits  enable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_jornadas enable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_partidos enable';
    
    elsif p_op = 'deshabilitar' then
    
        EXECUTE IMMEDIATE 'ALTER TRIGGER bloquear_splits disable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER  bloquear_jornadas  disable';
        EXECUTE IMMEDIATE 'ALTER TRIGGER  bloquear_partidos  disable';
        end if;
        
end habilitar_desabilitar_trigger;    
--------------------------------------------------------------------------------
END utilidades_base_kings_league;
