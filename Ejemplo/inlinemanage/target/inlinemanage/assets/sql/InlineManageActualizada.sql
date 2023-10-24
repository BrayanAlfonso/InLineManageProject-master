
DROP DATABASE IF EXISTS `inlinemanage`;
CREATE DATABASE IF NOT EXISTS `inlinemanage`;
USE `inlinemanage`;


CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombreCategoria` varchar(50) NOT NULL
);

insert into categoria values(1,'Cargadores');
insert into categoria values(2,'Audifonos');
insert into categoria values(3,'Cables 3x3');
insert into categoria values(4,'Cables 1x3');
insert into categoria values(5,'Cables cargador');


CREATE TABLE IF NOT EXISTS `entradaprod` (
  `idEntradaProd` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fechaIngreso` date DEFAULT NULL,
  `idProveedor` int(11) DEFAULT NULL
);
insert into entradaprod values (1, '2023-11-11', 1);
insert into entradaprod values (2, '2023-07-11', 2);
insert into entradaprod values (3, '2023-07-20', 3);

CREATE TABLE IF NOT EXISTS `existencia` (
  `idExistencia` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `cantidadUnidad` int(11) DEFAULT NULL,
  `precioEntrada` float DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `idEntradaProd` int(11) DEFAULT NULL

);
insert into existencia values (1, 20, 16000,1,1);
insert into existencia values (2, 14, 13000,2,2);
insert into existencia values (3, 14, 14000,2,3);
insert into existencia values (4, 14, 90000,2,1);
insert into existencia values (5, 14, 20000,2,1);


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
insert into producto values (2, 2, "Audifonos JQ 110",13000,"Audifnonos referencia JQ 110 color negro cable delgado",6789,12,6,2);
insert into producto values (3, 5, "Cable 3x3 JQ 220",9000,"Cable de audio 3x3",101112,12,6,3);
insert into producto values (4, 10, "Cable 1x3 JQ 95",7000,"Cable de audio 1x3",131415,12,6,4);
insert into producto values (5, 12, "Cargador cable tipo c a tipo c JQ 120",14000,"Cable tipo c a tipo c",161718,12,6,5);


CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nombreProveedor` varchar(50) DEFAULT NULL,
  `direccionProveedor` varchar(50) DEFAULT NULL
) ;

insert into proveedor values (1, 'Hector', 'Carrera 6 f este 25b 18 sur');
insert into proveedor values (2, 'Brayan', 'Carrera 8 f este 16 sur');
insert into proveedor values (3, 'Mateo', 'Carrera 56 f este 23c 14 sur');
insert into proveedor values (4, 'Sebastian', 'Carrera 90 f este 89c 5 sur');
insert into proveedor values (5, 'Laura', 'Carrera 15 f este 74d 3 sur');

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
    
    -- Trigers de venta --
    
DELIMITER //

CREATE TRIGGER antes_insertar_detalleventa
BEFORE INSERT ON detalle_venta
FOR EACH ROW
BEGIN
    -- Inserta una nueva venta
    INSERT INTO venta(fechaVenta, idUsuario)
    VALUES (NOW(), 1);

    -- Obtiene el idVenta recién insertado
    SET NEW.idVenta = LAST_INSERT_ID();
END;
//

insert into detalle_venta(idProducto, idVenta, precioProducto, cantidad)values(4,idVenta,20000,4);
select * from detalle_venta;
select * from venta;

