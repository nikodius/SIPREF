# Host: localhost  (Version: 5.6.25-log)
# Date: 2016-11-08 16:04:25
# Generator: MySQL-Front 5.3  (Build 4.214)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "directorioactivo"
#

CREATE TABLE `directorioactivo` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(50) NOT NULL,
  `contraseniaUsuario` varchar(50) NOT NULL,
  `idRol` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "directorioactivo"
#

INSERT INTO `directorioactivo` VALUES (1,'user','pass',1);

#
# Structure for table "estado_pregunta_respuesta"
#

CREATE TABLE `estado_pregunta_respuesta` (
  `Id_estado_pregunta_respuesta` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_estado` varchar(100) DEFAULT NULL,
  `Descripcion_pregunta_respuesta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_estado_pregunta_respuesta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "estado_pregunta_respuesta"
#

INSERT INTO `estado_pregunta_respuesta` VALUES (1,'Sin Aprobar',NULL),(2,'Aprobada',NULL),(3,'Inactiva',NULL);

#
# Structure for table "facultad"
#

CREATE TABLE `facultad` (
  `Id_Facultad` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_facultad` varchar(45) DEFAULT NULL,
  `Codigo_facultad` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Facultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "facultad"
#


#
# Structure for table "roles"
#

CREATE TABLE `roles` (
  `Id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_rol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "roles"
#

INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Autor');

#
# Structure for table "usuario"
#

CREATE TABLE `usuario` (
  `Id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_usuario` varchar(45) DEFAULT NULL,
  `Apellido_usuario` varchar(45) DEFAULT NULL,
  `Telefono_usuario` varchar(45) DEFAULT NULL,
  `Email_usuario` varchar(45) DEFAULT NULL,
  `Estado_usuario` varchar(45) DEFAULT NULL,
  `Id_rol` int(11) DEFAULT NULL,
  `Aprobar_pregunta_usuario` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`),
  KEY `Id_rol_idx` (`Id_rol`),
  CONSTRAINT `Id_rol` FOREIGN KEY (`Id_rol`) REFERENCES `roles` (`Id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=dec8;

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'Juan','Perez','64654','emal@mail.com',NULL,2,0);

#
# Structure for table "pregunta_respuesta"
#

CREATE TABLE `pregunta_respuesta` (
  `Id_pregunta_respuesta` int(11) NOT NULL AUTO_INCREMENT,
  `Contenido_pregunta` varchar(255) DEFAULT NULL,
  `Contenido_respuesta` varchar(255) DEFAULT NULL,
  `Fecha_creacion` date DEFAULT NULL,
  `inicio_vigencia` date DEFAULT NULL,
  `Id_usuario` int(11) DEFAULT NULL,
  `Id_facultad` int(11) DEFAULT NULL,
  `Id_estado_pregunta` int(11) DEFAULT NULL,
  `fin_vigencia` date DEFAULT NULL,
  PRIMARY KEY (`Id_pregunta_respuesta`),
  KEY `Id_usuario_idx` (`Id_usuario`),
  KEY `Id_facultad_idx` (`Id_facultad`),
  KEY `Id_estado_pregunta_respuesta_idx` (`Id_estado_pregunta`),
  CONSTRAINT `Id_estado_pregunta_respuesta` FOREIGN KEY (`Id_estado_pregunta`) REFERENCES `estado_pregunta_respuesta` (`Id_estado_pregunta_respuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Id_facultad` FOREIGN KEY (`Id_facultad`) REFERENCES `facultad` (`Id_Facultad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Id_usuario` FOREIGN KEY (`Id_usuario`) REFERENCES `usuario` (`Id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "pregunta_respuesta"
#

INSERT INTO `pregunta_respuesta` VALUES (2,'¿Como puedo ver las fechas de los grados?','Ingresando a www.poligran.edu.co opcion grados','2016-11-04','2016-11-30',NULL,NULL,2,'2016-12-31'),(3,'Cual es el proceso de admisiones','Debe inscribirse a través de la pagina www.poligran.edu.co/admisiones','2016-11-04','2016-11-30',NULL,NULL,1,'2016-12-31'),(4,'pregunta n','respuesta n','2016-11-04','2016-11-03',NULL,NULL,2,'2016-11-30'),(5,'pregunta 001','respuesta 001','2016-11-04','2016-11-11',NULL,NULL,2,'2016-11-25'),(6,'¿Como puedo ver mis notas?','entrando en www.poligran.edu.co/estudiantes con el usuario asignado en la opción calificaciones','2016-11-04','2016-11-03',NULL,NULL,2,'2016-11-30');

#
# Structure for table "comentario"
#

CREATE TABLE `comentario` (
  `Id_comentario` int(11) NOT NULL AUTO_INCREMENT,
  `Contenido_comentario` varchar(255) DEFAULT NULL,
  `Fecha_comentario` date DEFAULT NULL,
  `Nombre_presona_comenta` varchar(100) DEFAULT NULL,
  `Email_persona_comenta` varchar(100) DEFAULT NULL,
  `Id_padre_comentario` varchar(45) DEFAULT NULL,
  `Id_pregunta_respuesta` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_comentario`),
  KEY `Id_pregunta_respuesta_idx` (`Id_pregunta_respuesta`),
  CONSTRAINT `Id_pregunta_respuesta` FOREIGN KEY (`Id_pregunta_respuesta`) REFERENCES `pregunta_respuesta` (`Id_pregunta_respuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "comentario"
#

INSERT INTO `comentario` VALUES (1,'Gracias, ya pude consultar mis notas','2016-11-07','juan','juan@juan.com',NULL,6),(2,'sigo sin poder ver mis notas, por favor necesito mas informacion','2016-11-07','Paola','paola@hotmail.com',NULL,6);
