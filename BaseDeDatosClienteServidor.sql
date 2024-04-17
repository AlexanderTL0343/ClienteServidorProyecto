#Comentario
create database if not exists fideservidordb;

#seleccionar base de datos
use FideServidordb;

# crear tablas
create table if not exists usuario(
	id_usuario int primary key auto_increment,
    nombre_usuario varchar(50) not null,
	apellidos_usuario varchar(50) not null,
	cedula_usuario int not null,
    contrasena_usuario varchar(30) not null,
    telefono_usuario int not null,
    direccion_usuario varchar(150) not null,
    sexo_usuario int not null,
    anio_usuario int not null,
    nacionalidad_usuario varchar(20) not null,
    email_usuario varchar(50) not null
)engine = INNODB;

create table if not exists inventario(
	id_vehiculo int primary key auto_increment,
    tipo_vehiculo int not null,
    marca_vehiculo varchar(20) not null,
    anio_vehiculo int not null,
    modelo_vehiculo varchar(25) not null,
    precio_vehiculo double not null,
    disponible_vehiculo boolean

)engine = INNODB;

create table if not exists compra(
	id_compra int primary key auto_increment,
    estado_compra int not null,
    usuario_id_usuario int not null,
    foreign key(usuario_id_usuario) references usuario(id_usuario),
    vehiculo_id_vehiculo int not null,
    foreign key(vehiculo_id_vehiculo) references inventario(id_vehiculo)
)engine = INNODB;

create table if not exists login(
	id_login int primary key auto_increment,
    cedula_login int not null,
    contrasena_login varchar(30) not null,
    id_usuario_login int,
    foreign key (id_usuario_login) references usuario(id_usuario)

)engine = INNODB;


#insertar datos
INSERT INTO inventario(tipo_vehiculo, marca_vehiculo, anio_vehiculo, modelo_vehiculo, precio_vehiculo,disponible_vehiculo)
VALUES 	(1,"Ferrari",2004,"Huracan",6000000,true),
		(2,"Hyundai",2008,"Z-miedo",2000000,true),
        (3,"Volvo",2013,"Camion modelo",2000000,true);

INSERT INTO usuario(nombre_usuario, apellidos_usuario, cedula_usuario, contrasena_usuario, telefono_usuario, direccion_usuario, 
	sexo_usuario, anio_usuario, nacionalidad_usuario, email_usuario)
VALUES 	("Usuario","Prueba",1111,"pass",84789286,"Alajuela", 1, 2004,"Costarricense","meobligaronhacerunanueva@gmail.com");

INSERT INTO usuario(nombre_usuario, apellidos_usuario, cedula_usuario, contrasena_usuario, telefono_usuario, direccion_usuario, 
	sexo_usuario, anio_usuario, nacionalidad_usuario, email_usuario)
VALUES 	("Usuario","Prueba",1112,"pass",84789286,"Alajuela", 1, 2004,"Costarricense","meobligaronhacerunanueva@gmail.com");

INSERT INTO login(cedula_login,contrasena_login,id_usuario_login)
VALUES	(1111,"pass",1);

INSERT INTO login(cedula_login,contrasena_login,id_usuario_login)
VALUES	(1112,"pass",2);

INSERT INTO compra(estado_compra,usuario_id_usuario, vehiculo_id_vehiculo)
VALUES 	(1,1,2);

#mostrar tablas
select * from usuario;
select * from login;
select * from inventario;
select * from compra;








