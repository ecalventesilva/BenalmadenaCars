CREATE TABLE USUARIO(
NOMBRE VARCHAR(25),
PASSWORD VARCHAR(25),
DNI VARCHAR(10),
LICENCIA VARCHAR(9)
);


CREATE TABLE COCHES(
MARCA VARCHAR(25),
MODELO VARCHAR(25),
MATRICULA VARCHAR(7),
COLOR VARCHAR(15),
TIPO VARCHAR(15),
MOTOR VARCHAR(10),
DESCRIPCION VARCHAR(50),
PRECIO DECIMAL(5,2)
);
CREATE TABLE CLIENTES(
NOMBRE VARCHAR(25),
APELLIDOS VARCHAR(25),
DNI VARCHAR(10),
LICENCIA VARCHAR(9),
NACIONALIDAD VARCHAR(25),
FNACIMIENTO DATE,
DIRECCIONSPAIN VARCHAR(25),
RESIDENCIA VARCHAR(25)
);
describe coches;

CREATE TABLE ALQUILERES(
dniCliente varchar(10),
matriculaCoche varchar(7),
fechaInicio timestamp,
fechaFin timestamp,
primary key (dniCliente,matriculaCoche,fechaInicio),
foreign key (dniCliente) references clientes(dni),
foreign key (matriculaCoche) references coches(matricula)
);

-- Select * from usuario;
-- delete from usuario where licencia="77456123";

-- drop table usuario;