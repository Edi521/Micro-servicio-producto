USE PRODUCTOS; #Esta line es para indicar que se va a utilizar la BD Productos

DROP TABLE PRODUCTO;

#Iniciamos la creacion de la tabla producto y la descripcion de lo que se quiere almacenar en ella
CREATE TABLE PRODUCTO(
	ID_PRODUCTO INT,         #------------------> Estamos almacenando el id de producto
    
    NOMBRE VARCHAR(100), #------------------> Estamos almacenando el nombre de la producto
    
    PRECIO FLOAT,        #-------------------> Estamos almacenando el precio de la producto
    
    DESCRIPCION TEXT,   #--------------------> Estamos almacenando la descripcion de nuestro producto
    
    STOCK INT,         #---------------------> En esta parte se almacena el stock de nuestro producto
    
    CONSTRAINT PRODUCTO_PK PRIMARY KEY(ID_PRODUCTO)  #-----> Creando nuestra llave primaria de la tabla producto
);


SELECT * FROM PRODUCTO;  #--------------------> Verififcando el contenido de nuestra tabla

INSERT INTO PRODUCTO VALUES(1,'MANGO',5,'FRUTA DE COLOR AMARILLO',10); #----------------------> agregando valores prueva, para verificar funcionamiento

COMMIT;   #---------> confirmacion de cambios