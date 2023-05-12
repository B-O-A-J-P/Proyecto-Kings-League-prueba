drop view presidentes_equipos;
drop view entrenadores_equipos;
drop view staffs_equipos;


create view presidentes_equipos as
select m.cod_miembro, m.nombre, m.apellido, m.dni, cm.fecha_entrada, cm.fecha_salida, cm.cod_equipo, cm.funcion
from miembros m, contratos_equipo_miembro cm
where m.cod_miembro = cm.cod_miembro
and cm.funcion = 'p'
and fecha_entrada = (select max(fecha_entrada) from contratos_equipo_miembro where cm.cod_equipo = cod_equipo and funcion = cm.funcion);

create view entrenadores_equipos as
select m.cod_miembro, m.nombre, m.apellido, m.dni, cm.fecha_entrada, cm.fecha_salida, cm.cod_equipo, cm.funcion
from miembros m, contratos_equipo_miembro cm
where m.cod_miembro = cm.cod_miembro
and cm.funcion = 'e'
and fecha_entrada = (select max(fecha_entrada) from contratos_equipo_miembro where cm.cod_equipo = cod_equipo and funcion = cm.funcion);

create view staffs_equipos as
select m.cod_miembro, m.nombre, m.apellido, m.dni, cm.fecha_entrada, cm.fecha_salida, cm.cod_equipo, cm.funcion
from miembros m, contratos_equipo_miembro cm
where m.cod_miembro = cm.cod_miembro
and cm.funcion = 's'
and fecha_entrada = (select max(fecha_entrada) from contratos_equipo_miembro where cm.cod_equipo = cod_equipo and funcion = cm.funcion);
