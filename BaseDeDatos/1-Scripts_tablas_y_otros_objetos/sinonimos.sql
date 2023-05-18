DROP PUBLIC SYNONYM TS;
DROP PUBLIC SYNONYM PS;
DROP PUBLIC SYNONYM JS;
DROP PUBLIC SYNONYM ES;
DROP PUBLIC SYNONYM num_jug_equ;
DROP PUBLIC SYNONYM inf_equ_tem;
DROP PUBLIC SYNONYM inf_jug_ult_tem;
DROP PUBLIC SYNONYM get_num_jug_dra;
DROP PUBLIC SYNONYM pre_equ;
DROP PUBLIC SYNONYM ent_equ;
DROP PUBLIC SYNONYM sta_equ;

--Funciones y procedimientos almacenados
CREATE PUBLIC SYNONYM num_jug_equ FOR contar_numero_jugadores_por_equipo;
CREATE PUBLIC SYNONYM inf_equ_tem FOR informe_equipos_temporada;
CREATE PUBLIC SYNONYM inf_jug_ult_tem FOR informe_jugador_ultima_temporada;
CREATE PUBLIC SYNONYM get_num_jug_dra FOR get_numero_jugadores_draft;

--Vistas
CREATE PUBLIC SYNONYM pre_equ FOR presidentes_equipos;
CREATE PUBLIC SYNONYM ent_equ FOR entrenadores_equipos;
CREATE PUBLIC SYNONYM sta_equ FOR staffs_equipos;