--select * from contratos_equipo_miembro where cod_equipo = 0;

--select * from miembros;
--Prueba inserts
insert into miembros values(default, 'dni111', 'nombre111', 'apellido111', 0);
insert into contratos_equipo_miembro values(0, 36, default, 'p', sysdate+1, null);

--Prueba update
update contratos_equipo_miembro set cod_equipo = 0 where cod_equipo = 1 and funcion = 'p';