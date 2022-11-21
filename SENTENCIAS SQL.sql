-- MySQL Script generated by MySQL Workbench
-- mar 25 oct 2022 07:03:12 -05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Agenda_base_modelo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Agenda_base_modelo
-- -----------------------------------------------------
CREATE SCHEMA  Agenda_base_modelo DEFAULT CHARACTER SET utf8 ;
USE Agenda_base_modelo ;

-- -----------------------------------------------------
-- Table personas
-- -----------------------------------------------------
CREATE TABLE  personas (
  idpersona INT NOT NULL,
  nombres VARCHAR(45),
  apellidos VARCHAR(45),
  estado VARCHAR(1),
  fecha_registro VARCHAR(10),
  fecha_modificacion VARCHAR(10),
  PRIMARY KEY (idpersona));


-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
CREATE TABLE  users (
  iduser INT NOT NULL,
  clave VARCHAR(128) NOT NULL,
  tipo_user VARCHAR(1) NOT NULL,
  nombre_user VARCHAR(20) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  estado VARCHAR(1) NOT NULL,
  persona INT NOT NULL,
  PRIMARY KEY (iduser),
  CONSTRAINT fk_users_personas1
    FOREIGN KEY (persona)
    REFERENCES personas (idpersona)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table contactos
-- -----------------------------------------------------
CREATE TABLE  contactos (
  idcontacto INT NOT NULL,
  tipo_contacto VARCHAR(45) NOT NULL,
  persona INT NOT NULL,
  email VARCHAR(45),
  alias VARCHAR(45),
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  fecha_importante VARCHAR(10),
  tipo_fecha VARCHAR(15),
  grupo VARCHAR(15),
  relacion VARCHAR(15),
  sitio_web VARCHAR(60),
  visibilidad VARCHAR(1),
  PRIMARY KEY (idcontacto),
  CONSTRAINT fk_contactos_personas1
    FOREIGN KEY (persona)
    REFERENCES personas (idpersona)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table citas
-- -----------------------------------------------------
CREATE TABLE  citas (
  idcita INT NOT NULL,
  titulo VARCHAR(45) NOT NULL,
  descripcion VARCHAR(200),
  fecha_cita VARCHAR(10) NOT NULL,
  hora_cita VARCHAR(8) NOT NULL,
  tipo_cita VARCHAR(30) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  ubicacion VARCHAR(80),
  repeticion VARCHAR(1) NOT NULL,
  zona_horaria VARCHAR(60) NOT NULL,
  visibilidad VARCHAR(1) NOT NULL,
  PRIMARY KEY (idcita))
;


-- -----------------------------------------------------
-- Table notas
-- -----------------------------------------------------
CREATE TABLE  notas (
  idnota INT NOT NULL,
  titulo VARCHAR(45) NOT NULL,
  nota VARCHAR(1000) NOT NULL,
  hora VARCHAR(8) NOT NULL,
  evento INT,
  tipo_nota VARCHAR(45) NOT NULL,
  visibilidad VARCHAR(1) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  PRIMARY KEY (idnota),
  CONSTRAINT fk_notas_citas1
    FOREIGN KEY (evento)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table telefonos
-- -----------------------------------------------------
CREATE TABLE  telefonos (
  idtelefono INT NOT NULL,
  tipo_telefono VARCHAR(20) NOT NULL,
  telefono VARCHAR(15) NOT NULL,
  indicativo VARCHAR(45),
  contacto INT NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  PRIMARY KEY (idtelefono),
  CONSTRAINT fk_tel_num_contacto
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table direcciones
-- -----------------------------------------------------
CREATE TABLE  direcciones (
  iddireccion INT NOT NULL,
  direccion VARCHAR(80) NOT NULL,
  tipo_direccion VARCHAR(20) NOT NULL,
  contacto INT NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  PRIMARY KEY (iddireccion),
  CONSTRAINT fk_direccion_contacto
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table empresas
-- -----------------------------------------------------
CREATE TABLE  empresas (
  idempresas INT NOT NULL,
  nombre VARCHAR(40) NOT NULL,
  direccion VARCHAR(80),
  cargo VARCHAR(20),
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  contacto INT NOT NULL,
  PRIMARY KEY (idempresas),
  CONSTRAINT fk_empresas_contactos1
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table redes_sociales
-- -----------------------------------------------------
CREATE TABLE  redes_sociales (
  idred_social INT NOT NULL,
  nombre VARCHAR(60) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  contacto INT NOT NULL,
  PRIMARY KEY (idred_social),
  CONSTRAINT fk_redes_sociales_contactos1
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table etiquetas
-- -----------------------------------------------------
CREATE TABLE  etiquetas (
  idetiqueta INT NOT NULL,
  nombre VARCHAR(15) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  contacto INT,
  nota INT,
  PRIMARY KEY (idetiqueta),
  CONSTRAINT fk_etiquetas_contactos1
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_etiquetas_notas1
    FOREIGN KEY (nota)
    REFERENCES notas (idnota)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table recordatorios
-- -----------------------------------------------------
CREATE TABLE  recordatorios (
  idrecordatorio INT NOT NULL,
  fecha VARCHAR(10),
  hora VARCHAR(8),
  cita INT,
  tipo VARCHAR(1) NOT NULL,
  nota INT,
  PRIMARY KEY (idrecordatorio),
  CONSTRAINT fk_recordatorios_citas1
    FOREIGN KEY (cita)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_recordatorios_notas1
    FOREIGN KEY (nota)
    REFERENCES notas (idnota)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table metas
-- -----------------------------------------------------
CREATE TABLE  metas (
  idmeta INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  fecha_inicio VARCHAR(10) NOT NULL,
  fecha_fin VARCHAR(10) NOT NULL,
  cumplimiento VARCHAR(1) NOT NULL,
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  cita INT,
  tipo_meta VARCHAR(1) NOT NULL,
  nota INT,
  PRIMARY KEY (idmeta),
  CONSTRAINT fk_metas_citas1
    FOREIGN KEY (cita)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_metas_notas1
    FOREIGN KEY (nota)
    REFERENCES notas (idnota)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table invitados
-- -----------------------------------------------------
CREATE TABLE  invitados (
  idinvitado INT NOT NULL,
  cita INT NOT NULL,
  contacto INT,
  invitado VARCHAR(80),
  estado VARCHAR(1) NOT NULL,
  fecha_registro VARCHAR(10) NOT NULL,
  fecha_modificacion VARCHAR(10),
  PRIMARY KEY (idinvitado),
  CONSTRAINT fk_invitados_citas1
    FOREIGN KEY (cita)
    REFERENCES citas (idcita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_invitados_contactos1
    FOREIGN KEY (contacto)
    REFERENCES contactos (idcontacto)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
