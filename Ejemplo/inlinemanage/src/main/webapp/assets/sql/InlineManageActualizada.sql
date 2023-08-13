
DROP DATABASE IF EXISTS `inlinemanage`;
CREATE DATABASE IF NOT EXISTS `inlinemanage`;
USE `inlinemanage`;


CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombreCategoria` varchar(50) NOT NULL
);

insert into categoria values(1,'Cargadores');



CREATE TABLE IF NOT EXISTS `entradaprod` (
  `idEntradaProd` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fechaIngreso` date DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precioEntrada` float DEFAULT NULL,
  `idProveedor` int(11) DEFAULT NULL
);
insert into entradaprod values (1, 2023-11-11, 11, 16000, 1);

CREATE TABLE IF NOT EXISTS `existencia` (
  `idExistencia` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `numSerial` varchar(50) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `fechaGarantia` date DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `idEntradaProd` int(11) DEFAULT NULL

);



CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombreProducto` varchar(50) DEFAULT NULL,
  `precioProducto` int(11) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL,
  `idExistencia` int(11) DEFAULT NULL

);



CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombreProveedor` varchar(50) DEFAULT NULL,
  `direccionProveedor` varchar(50) DEFAULT NULL
) ;

insert into proveedor values (1, 'Hector', 'Carrera 6 f este 89c 18 sur');

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tipoDoc` varchar(50) DEFAULT NULL,
  `numeroDoc` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contraseña` varchar(50) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL
);

INSERT INTO usuario (idUsuario, tipoDoc, numeroDoc, nombre, apellido, correo, contraseña, idRol) values (1, "CC", 1019762839,"Brayan", "Alfonso", "brayanpaloma19b@gmail.com", "Brayan123@", 1);
CREATE TABLE IF NOT EXISTS `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `rol` varchar(50) DEFAULT NULL
);

INSERT INTO rol (idRol, rol) values (1, "Administrador");
INSERT INTO rol (idRol, rol) values (2, "Empleado");


CREATE TABLE IF NOT EXISTS `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fechaVenta` date DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS `detalle_venta`(
  `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idProducto` int(11) DEFAULT NULL,
`idVenta` int(11) DEFAULT NULL,
  `precioProducto` float DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
);

alter table existencia
drop idExistencia;

alter table existencia
add idExistencia int(11);

alter table existencia
add primary key (idExistencia, numSerial);
insert into existencia values (123456, 1, 2023-11-11, 'Observaciones de prueba', 1,1);

-- LLAVES FORANEAS

	alter table entradaProd
    add constraint FKentradaProdProveedor foreign key (idProveedor) references proveedor (idProveedor);
    
	alter table existencia
    add constraint FKExitenciaCate foreign key (idCategoria) references categoria (idCategoria);

	alter table existencia
    add constraint FKExistenciaEntradaProd foreign key (idEntradaProd) references entradaProd (idEntradaProd);
    
    
	alter table producto
    add constraint FKProdCate foreign key (idCategoria) references categoria (idCategoria);
    
	alter table producto
    add constraint FKProdExistencia foreign key (idExistencia) references existencia (idExistencia);
    
	alter table usuario
    add constraint FKUsuarioRol foreign key (idRol) references rol (idRol);
    
	alter table venta
    add constraint FKVentaUsu foreign key (idUsuario) references usuario (idUsuario);
    
	alter table detalle_venta
    add constraint FKDeveProd foreign key (idProducto) references producto (idProducto);
	
	alter table detalle_venta
    add constraint FKDeveVenta foreign key (idVenta) references venta (idVenta);
    

