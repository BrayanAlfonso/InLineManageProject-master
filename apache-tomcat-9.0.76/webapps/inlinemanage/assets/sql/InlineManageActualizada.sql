
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
  `idProveedor` int(11) DEFAULT NULL
);
insert into entradaprod values (1, 2023-11-11, 1);

CREATE TABLE IF NOT EXISTS `existencia` (
  `idExistencia` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `cantidadUnidad` int(11) DEFAULT NULL,
  `precioEntrada` float DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `idEntradaProd` int(11) DEFAULT NULL

);
insert into existencia values (1, 20, 16000,1,1);


CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `unidadesDisponibles` int(11) DEFAULT NULL,
  `nombreProducto` varchar(50) DEFAULT NULL,
  `precioVenta` float(11) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
	`serial` int(11) DEFAULT NULL,
    `garantiaEntradaMeses` int(11) DEFAULT NULL,
    `garantiaVentaMeses` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL

);
insert into producto values (1, 20, "Cargador JQ 130",20000,"Cargador Juqu Referencia 138 tipo C",12345,12,6,1);

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




-- LLAVES FORANEAS

	alter table entradaProd
    add constraint FKentradaProdProveedor foreign key (idProveedor) references proveedor (idProveedor);
    


	alter table existencia
    add constraint FKExistenciaEntradaProd foreign key (idEntradaProd) references entradaprod (idEntradaProd);
    
    
	alter table producto
    add constraint FKProdCate foreign key (idCategoria) references categoria (idCategoria);
    
	alter table existencia
    add constraint FKExistenciaProd foreign key (idProducto) references producto (idProducto);
    
	alter table usuario
    add constraint FKUsuarioRol foreign key (idRol) references rol (idRol);
    
	alter table venta
    add constraint FKVentaUsu foreign key (idUsuario) references usuario (idUsuario);
    
	alter table detalle_venta
    add constraint FKDeveProd foreign key (idProducto) references producto (idProducto);
	
	alter table detalle_venta
    add constraint FKDeveVenta foreign key (idVenta) references venta (idVenta);
    

