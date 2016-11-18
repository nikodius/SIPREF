# Host: localhost  (Version: 5.6.25-log)
# Date: 2016-11-18 16:17:33
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

#
# Data for table "directorioactivo"
#

INSERT INTO `directorioactivo` VALUES (1,'user','pass',2),(2,'autor','autor',2),(3,'admin','admin',1),(4,'autor2','autor2',2),(5,'administrador','adminitrador',1);

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

INSERT INTO `estado_pregunta_respuesta` VALUES (1,'Sin Aprobar',NULL),(2,'Aprobada',NULL),(3,'Sin Publicar',NULL);

#
# Structure for table "estado_usuario"
#

CREATE TABLE `estado_usuario` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "estado_usuario"
#

INSERT INTO `estado_usuario` VALUES (1,'Activo'),(2,'Inactivo');

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
# Structure for table "historial"
#

CREATE TABLE `historial` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) DEFAULT NULL,
  `accion` varchar(255) DEFAULT NULL,
  `fecha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

#
# Data for table "historial"
#

INSERT INTO `historial` VALUES (3,'admin','edito la pregunta como puedo cambiar mi contraseña','Thu Nov 17 10:46:58 COT 2016'),(12,'admin','desaprobó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:40 COT 2016'),(13,'admin','aprobó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:46 COT 2016'),(14,'admin','desaprobó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:47 COT 2016'),(15,'admin','inactivó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:49 COT 2016'),(16,'admin','publicó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:50 COT 2016'),(17,'admin','aprobó la pregunta:como puedo cambiar mi contraseña','Thu Nov 17 10:52:52 COT 2016'),(18,'admin','creo nueva pregunta: pregunta pendiente','Thu Nov 17 10:53:45 COT 2016'),(19,'autor','desaprobó el comentario:tenia otra pregunta, gracias por otra respuesta','Thu Nov 17 12:22:43 COT 2016'),(20,'autor','aprobó el comentario:tenia otra pregunta, gracias por otra respuesta','Thu Nov 17 12:22:45 COT 2016'),(21,'admin','creo nueva pregunta: asd','Fri Nov 18 12:40:15 COT 2016'),(22,'admin','inactivó la pregunta: asd','Fri Nov 18 12:40:21 COT 2016'),(23,'admin','creo nuevo Usuario: autor2','Fri Nov 18 12:40:38 COT 2016'),(24,'admin','inactivó la pregunta: null','Fri Nov 18 12:51:53 COT 2016'),(25,'admin','publicó la pregunta: asd','Fri Nov 18 12:52:33 COT 2016'),(26,'admin','inactivó la pregunta: asd','Fri Nov 18 12:52:34 COT 2016'),(27,'admin','inactivó al usuario: admin','Fri Nov 18 12:53:44 COT 2016'),(28,'admin','inactivó al usuario: admin','Fri Nov 18 12:53:45 COT 2016'),(29,'admin','inactivó al usuario: admin','Fri Nov 18 12:53:46 COT 2016'),(30,'admin','inactivó al usuario: admin','Fri Nov 18 12:54:53 COT 2016'),(31,'admin','inactivó al usuario: admin','Fri Nov 18 12:54:55 COT 2016'),(32,'admin','inactivó al usuario: admin','Fri Nov 18 12:54:56 COT 2016'),(33,'admin','inactivó al usuario: autor','Fri Nov 18 12:54:58 COT 2016'),(34,'admin','inactivó al usuario: autor','Fri Nov 18 12:54:59 COT 2016'),(35,'admin','inactivó al usuario: admin','Fri Nov 18 14:14:22 COT 2016'),(36,'admin','inactivó al usuario: admin','Fri Nov 18 14:17:13 COT 2016'),(37,'admin','inactivó al usuario: admin','Fri Nov 18 14:18:23 COT 2016'),(38,'admin','inactivó al usuario: admin','Fri Nov 18 14:18:54 COT 2016'),(39,'admin','activo al usuario: admin','Fri Nov 18 14:18:56 COT 2016'),(40,'admin','inactivó al usuario: admin','Fri Nov 18 14:18:57 COT 2016'),(41,'admin','activo al usuario: admin','Fri Nov 18 14:18:59 COT 2016'),(42,'admin','inactivó al usuario: admin','Fri Nov 18 14:19:01 COT 2016'),(43,'admin','activo al usuario: admin','Fri Nov 18 14:19:03 COT 2016'),(44,'admin','inactivó al usuario: autor','Fri Nov 18 14:19:04 COT 2016'),(45,'admin','activo al usuario: autor','Fri Nov 18 14:19:05 COT 2016'),(46,'admin','inactivó al usuario: autor','Fri Nov 18 14:19:06 COT 2016'),(47,'admin','inactivó al usuario: autor2','Fri Nov 18 14:19:08 COT 2016'),(48,'admin','activo al usuario: autor2','Fri Nov 18 14:19:09 COT 2016'),(49,'admin','inactivó al usuario: autor2','Fri Nov 18 14:19:11 COT 2016'),(50,'admin','activo al usuario: autor','Fri Nov 18 14:20:47 COT 2016'),(51,'admin','inactivó al usuario: autor','Fri Nov 18 14:20:49 COT 2016'),(52,'admin','activo al usuario: autor','Fri Nov 18 14:20:50 COT 2016'),(53,'admin','inactivó al usuario: admin','Fri Nov 18 14:20:51 COT 2016'),(54,'admin','activo al usuario: admin','Fri Nov 18 14:20:52 COT 2016'),(55,'admin','activo al usuario: autor2','Fri Nov 18 14:21:05 COT 2016'),(56,'admin','inactivó al usuario: autor2','Fri Nov 18 14:21:06 COT 2016'),(57,'admin','inactivó al usuario: autor','Fri Nov 18 14:21:08 COT 2016'),(58,'admin','inactivó al usuario: admin','Fri Nov 18 14:21:09 COT 2016'),(59,'admin','activo al usuario: admin','Fri Nov 18 14:21:11 COT 2016'),(60,'admin','publicó la pregunta: asd','Fri Nov 18 14:21:13 COT 2016'),(61,'admin','inactivó la pregunta: asd','Fri Nov 18 14:21:14 COT 2016'),(62,'admin','activo al usuario: autor','Fri Nov 18 14:21:27 COT 2016'),(63,'admin','inactivó al usuario: autor','Fri Nov 18 14:21:28 COT 2016'),(64,'admin','activo al usuario: autor','Fri Nov 18 14:21:30 COT 2016'),(65,'admin','inactivó al usuario: autor','Fri Nov 18 14:21:31 COT 2016'),(66,'admin','activo al usuario: autor','Fri Nov 18 14:23:17 COT 2016'),(67,'admin','activo al usuario: autor2','Fri Nov 18 14:23:19 COT 2016'),(68,'admin','inactivó al usuario: autor','Fri Nov 18 14:23:24 COT 2016'),(69,'admin','activo al usuario: autor','Fri Nov 18 14:23:51 COT 2016'),(70,'admin','inactivó al usuario: autor','Fri Nov 18 14:27:09 COT 2016'),(71,'admin','edito al usuario: user','Fri Nov 18 15:37:45 COT 2016'),(72,'admin','creo nuevo Usuario: administrador','Fri Nov 18 15:55:47 COT 2016'),(73,'admin','creo nuevo Usuario: administrador','Fri Nov 18 15:56:49 COT 2016'),(74,'admin','creo nuevo Usuario: administrador','Fri Nov 18 15:57:57 COT 2016'),(75,'admin','edito al usuario: autor','Fri Nov 18 15:59:00 COT 2016'),(76,'admin','creo nuevo Usuario: administrador','Fri Nov 18 15:59:19 COT 2016'),(77,'admin','creo nuevo Usuario: administrador','Fri Nov 18 16:00:50 COT 2016'),(78,'admin','creo nuevo Usuario: administrador','Fri Nov 18 16:02:31 COT 2016'),(79,'admin','activo al usuario: autor','Fri Nov 18 16:10:15 COT 2016'),(80,'admin','inactivó al usuario: user','Fri Nov 18 16:10:19 COT 2016'),(81,'admin','inactivó la pregunta: como puedo cambiar mi contraseña','Fri Nov 18 16:14:33 COT 2016'),(82,'admin','publicó la pregunta: como puedo cambiar mi contraseña','Fri Nov 18 16:14:43 COT 2016'),(83,'admin','publicó la pregunta: Cual es el proceso de admisiones','Fri Nov 18 16:14:46 COT 2016'),(84,'admin','inactivó la pregunta: pregunta n','Fri Nov 18 16:14:53 COT 2016'),(85,'admin','inactivó la pregunta: pregunta001','Fri Nov 18 16:15:02 COT 2016'),(86,'admin','aprobó la pregunta: como puedo cambiar mi contraseña','Fri Nov 18 16:15:12 COT 2016'),(87,'admin','publicó la pregunta: otra pregunta','Fri Nov 18 16:15:15 COT 2016'),(88,'admin','aprobó la pregunta: otra pregunta','Fri Nov 18 16:15:20 COT 2016'),(89,'admin','aprobó la pregunta: ¿Como aplico a una beca?','Fri Nov 18 16:15:29 COT 2016'),(90,'admin','aprobó la pregunta: Cual es el proceso de admisiones','Fri Nov 18 16:15:32 COT 2016');

#
# Structure for table "roles"
#

CREATE TABLE `roles` (
  `Id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
  `id_estado_usuario` int(11) DEFAULT NULL,
  `Id_rol` int(11) DEFAULT NULL,
  `Aprobar_pregunta_usuario` tinyint(1) DEFAULT '0',
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`),
  KEY `Id_rol_idx` (`Id_rol`),
  CONSTRAINT `Id_rol` FOREIGN KEY (`Id_rol`) REFERENCES `roles` (`Id_rol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=dec8;

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'Juancho','Perez','64654','emal@mail.com',2,2,0,'user'),(2,'Pepe','Perez','165845','pepe@pepe.com',1,2,1,'autor'),(3,'Administrator','PL','123123','admin@admin.com',1,1,1,'admin'),(4,'Fransisco','Diaz','123123','fcx@correo.com',1,2,0,'autor2'),(5,'Fransisco','Infante','123123','pepp@oasd.co',1,1,0,'administrador');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

#
# Data for table "pregunta_respuesta"
#

INSERT INTO `pregunta_respuesta` VALUES (2,'¿Como puedo ver las fechas de los grados?','Ingresando a www.poligran.edu.co opcion grados','2016-11-04','2016-11-30',1,NULL,2,'2016-12-31'),(3,'Cual es el proceso de admisiones','Debe inscribirse a través de la pagina www.poligran.edu.co/admisiones','2016-11-04','2016-11-30',2,NULL,2,'2016-12-31'),(4,'pregunta n','respuesta n','2016-11-04','2016-11-03',1,NULL,3,'2016-11-30'),(5,'pregunta 001','respuesta 001','2016-11-04','2016-11-11',1,NULL,1,'2016-11-25'),(6,'¿Como puedo ver mis notas?','entrando en www.poligran.edu.co/estudiantes con el usuario asignado en la opción calificaciones','2016-11-04','2016-11-03',2,NULL,2,'2016-11-30'),(7,'como puedo cambiar mi contraseña','En la opcion de gestion de cuenta','2016-11-10','2016-11-04',1,NULL,2,'2016-11-30'),(8,'otra pregunta','otra respuesta','2016-11-10','2016-11-09',2,NULL,2,'2016-11-30'),(11,'¿Como aplico a una beca?','Entrando en www.poligran.edu.co/becas y diligenciando el formulario','2016-11-16','2016-11-02',3,NULL,2,'2016-11-30'),(12,'pregunta001','respuesta001','2016-11-17','2016-11-02',2,NULL,3,'2016-11-05'),(13,'pregunta pendiente','respuesta pendiente','2016-11-17','2016-11-02',3,NULL,1,'2016-11-30'),(14,'asd','asd','2016-11-18','2016-11-17',3,NULL,3,'2016-11-25');

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
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`Id_comentario`),
  KEY `Id_pregunta_respuesta_idx` (`Id_pregunta_respuesta`),
  CONSTRAINT `Id_pregunta_respuesta` FOREIGN KEY (`Id_pregunta_respuesta`) REFERENCES `pregunta_respuesta` (`Id_pregunta_respuesta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "comentario"
#

INSERT INTO `comentario` VALUES (1,'Gracias, ya pude consultar mis notas','2016-11-07','juan','juan@juan.com',NULL,6,1),(2,'sigo sin poder ver mis notas, por favor necesito mas informacion','2016-11-07','Paola','paola@hotmail.com',NULL,6,1),(3,'tenia otra pregunta, gracias por otra respuesta','2016-11-10','Pepe','pepe@mail.com',NULL,8,1),(4,'POr favor expliquen un poco mas de este proceso, es confuso, gracias','2016-11-18','Natalia','nata@coreo.com',NULL,11,1);
