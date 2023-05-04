DROP TABLE contratos_equipo_miembro;
DROP TABLE miembros CASCADE CONSTRAINTS;
DROP TABLE contratos_equipo_jugador;
DROP TABLE draft;
DROP TABLE agendas CASCADE CONSTRAINTS;
DROP TABLE jugadores CASCADE CONSTRAINTS;
DROP TABLE informacion_partidos CASCADE CONSTRAINTS;
DROP TABLE tabla_clasificaciones CASCADE CONSTRAINTS;
DROP TABLE equipos CASCADE CONSTRAINTS;
DROP TABLE partidos CASCADE CONSTRAINTS;
DROP TABLE jornadas CASCADE CONSTRAINTS;
DROP TABLE splits CASCADE CONSTRAINTS;
DROP TABLE temporadas CASCADE CONSTRAINTS;

CREATE TABLE temporadas(
    cod_temporada NUMBER(5, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    ano NUMBER(4),
    fecha_inicio_inscripcion DATE,
    fecha_fin_inscripcion DATE,
    CONSTRAINT tem_cod_pk PRIMARY KEY (cod_temporada),
    CONSTRAINT tem_fec_fin CHECK (fecha_fin_inscripcion > fecha_inicio_inscripcion)
);

/
CREATE OR REPLACE TRIGGER trigger_temporadas_ano
BEFORE INSERT OR UPDATE ON temporadas
FOR EACH ROW
BEGIN
  IF :NEW.ano < EXTRACT(YEAR FROM TRUNC(SYSDATE)) THEN
    RAISE_APPLICATION_ERROR(-20001, 'El año tiene que ser igual o superior al año actual.');
  END IF;
END;
/

CREATE TABLE splits(
    cod_temporada NUMBER(5, 0),    
    cod_split NUMBER(6, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    nombre VARCHAR2(20),
    fecha_inicio DATE,
    fecha_fin DATE,
    CONSTRAINT spl_cod_tem_fk FOREIGN KEY (cod_temporada) REFERENCES temporadas,
    CONSTRAINT spl_cod_spl_pk PRIMARY KEY (cod_split),
    CONSTRAINT spl_fec_fin_ck CHECK (fecha_fin > fecha_inicio)
);

/

CREATE OR REPLACE TRIGGER triger_splits_fec_ini
BEFORE INSERT OR UPDATE ON splits
FOR EACH ROW
BEGIN
  IF :NEW.fecha_inicio < (SYSDATE) THEN
    RAISE_APPLICATION_ERROR(-20001, 'La fecha tiene que ser igual o superior a la fecha actual');
  END IF;
END;

/


CREATE TABLE jornadas(
    cod_split NUMBER(6, 0),
    cod_jornada NUMBER(7, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    numero NUMBER(2),
    fecha DATE,
    ubicacion VARCHAR2(50),
    CONSTRAINT jor_cod_jor_pk PRIMARY KEY (cod_jornada),
    CONSTRAINT jor_cod_spl_fk FOREIGN KEY (cod_split) REFERENCES splits
);

/

CREATE OR REPLACE TRIGGER triger_jornadas_fec
BEFORE INSERT OR UPDATE ON jornadas
FOR EACH ROW
BEGIN
  IF :NEW.fecha < (SYSDATE) THEN
    RAISE_APPLICATION_ERROR(-20001, 'La fecha tiene que ser igual o superior a la fecha actual.');
  END IF;
END;

/

CREATE TABLE equipos(
    cod_equipo NUMBER(6, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    nombre VARCHAR2(50),
    logo BLOB, 
    presupuesto NUMBER(11, 2),
    CONSTRAINT equ_cod_pk PRIMARY KEY (cod_equipo)
);

CREATE TABLE partidos(
  cod_jornada NUMBER(7, 0),
  cod_partido NUMBER(8, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
  cod_equipo1 NUMBER(6, 0),
  cod_equipo2 NUMBER(6, 0),
  hora timestamp,
  equipo_ganador NUMBER(6, 0),
  fase VARCHAR2(1) DEFAULT 'r',
  CONSTRAINT par_cod_equ1_fk FOREIGN KEY (cod_equipo1) REFERENCES equipos,
  CONSTRAINT par_cod_equ2_fk FOREIGN KEY (cod_equipo2) REFERENCES equipos,
  CONSTRAINT par_cod_jor_pk PRIMARY KEY (cod_partido),
  CONSTRAINT par_cod_par_fk FOREIGN KEY (cod_jornada) REFERENCES jornadas,
  CONSTRAINT par_gan_fk FOREIGN KEY (equipo_ganador) REFERENCES equipos,
 -- CONSTRAINT par_hor_ck CHECK (hora LIKE 'HH24:MI'),
  CONSTRAINT par_fas_ck CHECK (fase in ('r', 's', 'f'))
  -- r = regular | s = semifinal | f = final
);


CREATE TABLE tabla_clasificaciones (
    cod_split NUMBER(6, 0),
    cod_equipo NUMBER(6, 0),
    posicion NUMBER(3),
    CONSTRAINT cla_spl_fk FOREIGN KEY (cod_split) REFERENCES splits,
    CONSTRAINT cla_equ_fk FOREIGN KEY (cod_equipo) REFERENCES equipos,
    CONSTRAINT cla_cod_pk PRIMARY KEY (cod_split, cod_equipo)
);

CREATE TABLE informacion_partidos (
    cod_partido NUMBER(8, 0),
    cod_equipo NUMBER(6, 0),
    numero_goles NUMBER(2),
    resultado VARCHAR2(1),
    CONSTRAINT inf_cod_par_fk FOREIGN KEY (cod_partido) REFERENCES partidos,
    CONSTRAINT inf_cod_equ_fk FOREIGN KEY (cod_equipo) REFERENCES equipos,
    CONSTRAINT info_cod_pk PRIMARY KEY (cod_partido, cod_equipo),
    CONSTRAINT inf_res_ck CHECK (resultado in ('v', 'd'))
    -- v = victoria | d = derrota
);

CREATE TABLE agendas (
    cod_agenda NUMBER(8, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    email VARCHAR2(50),
    telefono VARCHAR2(9),
    CONSTRAINT age_cod_pk PRIMARY KEY (cod_agenda)
);

CREATE TABLE jugadores (
    cod_jugador NUMBER(6, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    dni VARCHAR(9),
    nombre VARCHAR2(50),
    apellido VARCHAR2(50),
    pie VARCHAR(20),
    altura NUMBER(3), --en centímetros
    cod_agenda NUMBER(8),
    posicion varchar2(20),
    CONSTRAINT jug_cod_jug_pk PRIMARY KEY (cod_jugador),
    CONSTRAINT jug_co_age_fk FOREIGN KEY (cod_agenda) REFERENCES agendas
);

CREATE TABLE draft (
    cod_temporada NUMBER(5, 0),
    cod_jugador NUMBER(6, 0),
    posicion NUMBER(3),
    CONSTRAINT dra_cod_tem_fk FOREIGN KEY (cod_temporada) REFERENCES temporadas,
    CONSTRAINT dra_cod_jug_fk FOREIGN KEY (cod_jugador) REFERENCES jugadores,
    CONSTRAINT dra_cod_pk PRIMARY KEY (cod_temporada, cod_jugador)
);

CREATE TABLE contratos_equipo_jugador (
    cod_equipo NUMBER(6, 0),
    cod_jugador NUMBER(4, 0),
    cod_contrato NUMBER(7, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    salario NUMBER(8),
    clausula NUMBER(8),
    fecha_inicio DATE,
    fecha_fin DATE,
    CONSTRAINT con_jug_equ_fk FOREIGN KEY (cod_equipo) REFERENCES equipos,
    CONSTRAINT con_jug_mie_fk FOREIGN KEY (cod_jugador) REFERENCES jugadores,
    CONSTRAINT con_jug_cod_pk PRIMARY KEY (cod_contrato),
    CONSTRAINT con_sal_ck CHECK (salario in (10000000, 10500000, 15000000, 22500000))
);

CREATE TABLE miembros (
    cod_miembro NUMBER(4, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    dni VARCHAR(9),
    nombre VARCHAR2(50),
    apellido VARCHAR2(50),
    cod_agenda NUMBER(8, 0),
    CONSTRAINT mie_cod_pk PRIMARY KEY (cod_miembro)
);

CREATE TABLE contratos_equipo_miembro (
    cod_equipo NUMBER(6, 0),
    cod_miembro NUMBER(4, 0),
    cod_contrato NUMBER (6, 0) GENERATED ALWAYS AS IDENTITY INCREMENT BY 1 START WITH 0 MINVALUE 0 NOCYCLE NOT NULL ENABLE,
    funcion VARCHAR2(1),
    fecha_entrada DATE,
    fecha_salida DATE,
    CONSTRAINT con_mie_equ_fk FOREIGN KEY (cod_equipo) REFERENCES equipos,
    CONSTRAINT con_mie_mie_fk FOREIGN KEY (cod_miembro) REFERENCES miembros,
    CONSTRAINT con_mie_cod_pk PRIMARY KEY (cod_contrato),
    CONSTRAINT con_fun_ck CHECK (funcion in ('p', 'e', 's')) 
    -- p = propietario | e = entrenador | s = staff
);

CREATE TABLE equipos_participantes (
    cod_temporada NUMBER(5, 0),
    cod_equipo NUMBER(6, 0),
    CONSTRAINT equ_par_tem_fk FOREIGN KEY (cod_temporada) REFERENCES temporadas,
    CONSTRAINT equ_par_equ_fk FOREIGN KEY (cod_equipo) REFERENCES equipos,
    CONSTRAINT equ_tem_equ_pk PRIMARY KEY (cod_temporada, cod_equipo)
);
