
DROP DATABASE IF EXISTS bdfenix;
CREATE DATABASE bdfenix;

USE bdfenix;

CREATE TABLE VENDEDOR(
  ID_VEND     INT          PRIMARY KEY AUTO_INCREMENT,
  DNI_VEND    CHAR(8)      NOT NULL UNIQUE,
  NOM_VEND    VARCHAR(50)  NOT NULL,
  APE_VEND    VARCHAR(50)  NOT NULL,
  DIREC_VEND  VARCHAR(100)  NOT NULL,
  TELEF_VEND  VARCHAR(15)  NOT NULL UNIQUE,
  ESTADO      INT          NOT NULL,
  TIPO        INT          NOT NULL # 0 -> admi , # 1 -> vendedor
);

CREATE TABLE LOGIN(
  USERNAME  VARCHAR(15)  NOT NULL PRIMARY KEY,
  CLAVE     VARCHAR(50)  NOT NULL,
  ID_VEND   INT          NOT NULL,
  FOREIGN KEY (ID_VEND) REFERENCES VENDEDOR(ID_VEND)
);

CREATE TABLE CLIENTE(
  ID_CLI     INT          PRIMARY KEY AUTO_INCREMENT,
  DNI_CLI    CHAR(8)      NOT NULL UNIQUE,
  NOM_CLI    VARCHAR(50)  NOT NULL,
  APE_CLI    VARCHAR(50)  NOT NULL,
  DIREC_CLI  VARCHAR(100)  NOT NULL,
  TELEF_CLI  VARCHAR(15)  NOT NULL UNIQUE,
  ESTADO     INT          NOT NULL
);

CREATE TABLE TIPO_PRODUCTO(
  ID_TIPO_PRO   INT          PRIMARY KEY AUTO_INCREMENT,
  DESC_TIPO     VARCHAR(30)  NOT NULL
);

CREATE TABLE MARCA_PRODUCTO(
  ID_MARC_PRO  INT         PRIMARY KEY AUTO_INCREMENT,
  DESC_MARCA   VARCHAR(25) NOT NULL
);

CREATE TABLE PRODUCTO(
  COD_PRO        CHAR(8)       NOT NULL PRIMARY KEY,  
  DESC_PRO       VARCHAR(50)   NOT NULL,
  ID_MARC_PRO    INT           NOT NULL,
  ID_TIPO_PRO    INT           NOT NULL,
  STOCK_PRO      INT           NOT NULL CHECK (STOCK_PRO >= 0),
  PREC_UNIT_PRO  DECIMAL(10,2) NOT NULL CHECK (PREC_UNIT_PRO > 0.0),
  ESTADO         INT           NOT NULL,
  
  FOREIGN KEY (ID_TIPO_PRO) REFERENCES TIPO_PRODUCTO(ID_TIPO_PRO), 
  FOREIGN KEY (ID_MARC_PRO) REFERENCES MARCA_PRODUCTO(ID_MARC_PRO)  
);

CREATE TABLE BOLETA(
  NUM_BOL     INT           PRIMARY KEY AUTO_INCREMENT,
  FECH_BOL    DATE          NOT NULL,
  SUB_TOT_BOL DECIMAL(10,2) NOT NULL CHECK (SUB_TOT_BOL > 0),
  DESCU_BOL   DECIMAL(10,2) NOT NULL DEFAULT 0.0,
  TOT_BOL     DECIMAL(10,2) NOT NULL CHECK (TOT_BOL > 0),
  ID_CLI      INT           NOT NULL,
  
  FOREIGN KEY (ID_CLI) REFERENCES CLIENTE(ID_CLI)
);

CREATE TABLE DETALLE_BOLETA(
  NUM_BOL       INT            NOT NULL,
  COD_PRO       CHAR(8)        NOT NULL,
  IMP_PRO       DECIMAL(10,1)  NOT NULL,
  CANT_COMP_BOL INT            NOT NULL,
  
  PRIMARY KEY(NUM_BOL, COD_PRO),
  
  FOREIGN KEY (NUM_BOL) REFERENCES BOLETA(NUM_BOL),
  FOREIGN KEY (COD_PRO) REFERENCES PRODUCTO(COD_PRO)
);

CREATE TABLE VENTA(
  NUM_VENT INT  AUTO_INCREMENT,
  ID_VEND  INT  NOT NULL,
  NUM_BOL  INT  NOT NULL,
  
  PRIMARY KEY (NUM_VENT, ID_VEND, NUM_BOL),
  
  FOREIGN KEY (ID_VEND) REFERENCES VENDEDOR(ID_VEND),
  FOREIGN KEY (NUM_BOL) REFERENCES BOLETA(NUM_BOL)
);

INSERT INTO TIPO_PRODUCTO VALUES (null, 'Figuras de Acción');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Modelismo');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Modelismo 3D');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Juegos de Mesa');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Miniaturas');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Consolas y Videojuegos');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Antiguedades');
INSERT INTO TIPO_PRODUCTO VALUES (null, 'Varios');

SELECT * FROM TIPO_PRODUCTO;

INSERT INTO MARCA_PRODUCTO VALUES (null, 'Mattel');
INSERT INTO MARCA_PRODUCTO VALUES (null, 'Hasbro');
INSERT INTO MARCA_PRODUCTO VALUES (null, 'Lego');
INSERT INTO MARCA_PRODUCTO VALUES (null, 'Fischer-Price');
INSERT INTO MARCA_PRODUCTO VALUES (null, 'Hot Wheels');
INSERT INTO MARCA_PRODUCTO VALUES (null, 'Nerf');

SELECT * FROM MARCA_PRODUCTO;

-- Procedure : Actualizar Producto
delimiter $$
CREATE PROCEDURE usp_actualizarProducto(
  cod CHAR(8), descripcion VARCHAR(50),
  marca INT, tipo INT, stock INT,
  precio DECIMAL(10,2)
)
BEGIN
  UPDATE PRODUCTO
  SET DESC_PRO = descripcion,
     ID_MARC_PRO = marca,
     ID_TIPO_PRO = tipo,
     STOCK_PRO = stock,
     PREC_UNIT_PRO = precio     
  where COD_PRO = cod;
END $$
delimiter ;

-- Procedure : Generar Codigo Producto
delimiter $$
CREATE PROCEDURE usp_generarCodigoProducto()
BEGIN
  SELECT SUBSTRING(COD_PRO, 5)
  FROM PRODUCTO ORDER BY COD_PRO DESC LIMIT 1;
END $$
delimiter ;

INSERT INTO CLIENTE VALUES (1, '12345678', 'Harry', 'Potter', 'Av. Santa Fe 4815 C1425BHK - Ciudad Autónoma de Buenos Aires', '43466239', 1);
INSERT INTO CLIENTE VALUES (2, '87654321', 'Ronald', 'Weasley', 'Piedras 141 C1070AAC - Ciudad Autónoma de Buenos Aires', '43353509', 1);
INSERT INTO CLIENTE VALUES (3, '00100234', 'Hermione', 'Granger', 'Paso 551 C1031ABK - Ciudad Autónoma de Buenos Aires', '2223300', 1);
INSERT INTO CLIENTE VALUES (4, '17171717', 'Draco', 'Malfoy', 'Av. Cabildo 65 1° piso C1426AAA - Ciudad Autónoma de Buenos Aires', '8884373', 1);
INSERT INTO CLIENTE VALUES (5, '00100567', 'Sirius', 'Black', 'Adolfo Alsina 323, C1002ABA CABA, Argentina', '5550004', 0);
INSERT INTO CLIENTE VALUES (6, '00200666', 'Lucius', 'Malfoy', 'Florida 328, C1005AAH CABA, Argentina', '5550005', 0);
INSERT INTO CLIENTE VALUES (7, '00200896', 'Bellatrix', 'Lestrange', 'Ayacucho 1050 CABA, Argentina 1111', '35352170', 1);
INSERT INTO CLIENTE VALUES (8, '12200896', 'Molly', 'Weasley', 'Av. Sargento Mayor Cayetano Beliera 3025, CABA, Argentina', '52633158', 1);
INSERT INTO CLIENTE VALUES (9, '62201896', 'Albus', 'Dumbledore', 'Ruta Panamericana Km 36, Tortuguitas, Pcia. de Buenos Aires', '33274580', 1);
INSERT INTO CLIENTE VALUES (10, '82401895', 'Severus', 'Snape', 'Pte. Roca 4145 S2001KDK, Rosario, Santa Fe, Argentina', '4655777', 1);


SELECT * FROM CLIENTE;

delimiter $$
CREATE PROCEDURE usp_ReporteProductoListado()
BEGIN
SELECT
	p.COD_PRO,  
	p.DESC_PRO,
	m.DESC_MARCA,
	T.DESC_TIPO,
	P.STOCK_PRO,
	P.PREC_UNIT_PRO
	FROM PRODUCTO p JOIN  TIPO_PRODUCTO t 
      on p.ID_TIPO_PRO = t.ID_TIPO_PRO 
	join MARCA_PRODUCTO m 
      on p.ID_MARC_PRO = m.ID_MARC_PRO
	WHERE p.ESTADO = 1;
END $$
delimiter ; 

CALL usp_ReporteProductoListado(); 

INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Airwaves');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Edward');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Brassin');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Trumpeter');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Master');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Isra Cast');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'True Details');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Flexifile');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Hasegawa');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Nintendo');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Sega');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Atari');
INSERT INTO MARCA_PRODUCTO VALUES (NULL, 'Sony');

SELECT * FROM MARCA_PRODUCTO;
SELECT * FROM TIPO_PRODUCTO;

INSERT INTO PRODUCTO VALUES ('PROD0001', 'Figuras de Plomo', 7, 2, 10, 500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0002', '1/35 TP520 GERMAN PANZER WWII', 8, 2, 3, 2400, 1);
INSERT INTO PRODUCTO VALUES ('PROD0003', 'Millenium Princess Barbie', 1, 8, 1, 8500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0004', '1969 Red Baron', 5, 5, 1, 3400, 1);
INSERT INTO PRODUCTO VALUES ('PROD0005', 'LEGO Kings Castle', 3, 8, 1, 7500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0006', 'AIRCRAFT WEAPONS E 1/48 COMPLETO', 5, 2, 1, 5000, 1);
INSERT INTO PRODUCTO VALUES ('PROD0007', 'NES Classic', 16, 6, 1, 6000, 1); 
INSERT INTO PRODUCTO VALUES ('PROD0008', 'Atari Flashback 8 Gold Deluxe', 18, 6, 2, 7000, 1);
INSERT INTO PRODUCTO VALUES ('PROD0009', 'PlayStation Classic', 19, 6, 3, 5500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0010', 'Sega Genesis', 17, 6, 1, 4500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0011', 'Beyblade Burst Surge Speedstorm', 2, 8, 6, 1500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0012', 'Chatter Telephone', 4, 8, 7, 2600, 1);
INSERT INTO PRODUCTO VALUES ('PROD0013', 'Lanzador Nerf Elite Shellstrike DS-6', 6, 8, 4, 5500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0014', 'Spitfire Mk. VIII cockpit 1/48', 9, 3, 2, 500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0015', 'Titanic（W/LED） 03719', 10, 1, 4, 990, 1);
INSERT INTO PRODUCTO VALUES ('PROD0016', 'Supermarine Spitfire Mk.IXc', 11, 4, 3, 600, 1);
INSERT INTO PRODUCTO VALUES ('PROD0017', 'Dassault MD450 Ouragan', 12, 6, 4, 4500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0018', 'Python 3 missiles for F-4E Phantoms', 12, 5, 4, 6500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0019', 'Grumman F6F Hellcat model kit', 13, 7, 8, 3500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0021', '#1311GSW Miniature Leaf Punch - DARK GREEN', 14, 3, 1, 1500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0022', '#1415GSW Miniature Leaf Punch - MEDIUM BLUE', 14, 3, 1, 1500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0023', 'ADVAN COROLLA LEVIN AE92 “1989 INTER TEC”', 15, 5, 2, 10500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0024', 'Sega DreamCast', 17, 6, 5, 5500, 1);
INSERT INTO PRODUCTO VALUES ('PROD0025', 'Atari 2600', 18, 6, 6, 5700, 1);
INSERT INTO PRODUCTO VALUES ('PROD0026', 'Playstation 2', 19, 6, 3, 4300, 1);

SELECT * FROM PRODUCTO;

INSERT INTO VENDEDOR VALUES (1, '77416188', 'Jose', 'Atuncar', '701 Brickell Ave #1550, Miami, FL', '1117777', 1, 0);
INSERT INTO VENDEDOR VALUES (2, '77494174', 'Jose', 'Robles', 'Buenos Aires 322 Sicuani-Ate', '6665555', 1, 1);
INSERT INTO VENDEDOR VALUES (3, '00000000', 'Elena', 'Efimova', '777 Monte Olimpo', '5550000', 1, 1);
SELECT * FROM VENDEDOR;

-- Procedure : Actualizar Vendedor
delimiter $$
CREATE PROCEDURE usp_actualizarVendedor(
  dni CHAR(8), nombre VARCHAR(50), apellido VARCHAR(50),
  direccion VARCHAR(80), telefono VARCHAR(15), est INT
)
BEGIN
  UPDATE VENDEDOR
  SET NOM_VEND = nombre,
	  APE_VEND = apellido,
      DIREC_VEND = direccion,
      TELEF_VEND = telefono,
      ESTADO = est
  WHERE DNI_VEND = dni AND TIPO = 1;
END $$
delimiter ;

INSERT INTO LOGIN VALUES('admin', 'admin123', 1);
INSERT INTO LOGIN VALUES('jossrc', 'vend123', 2);
INSERT INTO LOGIN VALUES('elenae', 'vend456', 3);

-- Procedure : Obtener vendedor y logueo
delimiter $$
CREATE PROCEDURE usp_obtenerVendedorYLogueo(id int)
BEGIN
  SELECT V.*
  FROM LOGIN AS L
  INNER JOIN VENDEDOR AS V
    ON L.ID_VEND = V.ID_VEND
  WHERE V.ID_VEND = id AND V.ESTADO = 1;
END $$
delimiter ;

call usp_obtenerVendedorYLogueo(1);

-- Procedure : Comprar productos

delimiter $$
CREATE PROCEDURE usp_compraProducto(cant int, cod char(8))
BEGIN
  UPDATE PRODUCTO
  SET STOCK_PRO = STOCK_PRO - cant
  WHERE COD_PRO = cod;
END $$
delimiter ;

-- Procedure:Busca un producto con su tipo y marca
delimiter $$
CREATE PROCEDURE usp_buscarProductoTipoMarca(cod char(8))
BEGIN
	SELECT 
    p.COD_PRO,  
	p.DESC_PRO,
	m.DESC_MARCA,
	T.DESC_TIPO,
	P.STOCK_PRO,
	P.PREC_UNIT_PRO
	FROM PRODUCTO p
    JOIN  TIPO_PRODUCTO t 
      on p.ID_TIPO_PRO = t.ID_TIPO_PRO 
	join MARCA_PRODUCTO m 
      on p.ID_MARC_PRO = m.ID_MARC_PRO
	WHERE p.COD_PRO = cod;
END $$
delimiter ;

call usp_buscarProductoTipoMarca('PROD0001');


INSERT INTO BOLETA VALUES (1, '2020/11/30', 500, 0, 500, 1);
INSERT INTO DETALLE_BOLETA VALUES (1, 'PROD0001', 500, 1);
INSERT INTO VENTA VALUES (1, 2, 1);

SELECT * FROM BOLETA;
SELECT * FROM DETALLE_BOLETA;
SELECT * FROM VENTA;

-- PROCEDURES PARA VENTAS CONCRETADAS

-- Cantidad de ventas en un rango de fecha
delimiter $$
CREATE PROCEDURE usp_buscarCantidadVentasEnFechas(fech1 DATE, fech2 DATE)
BEGIN	
	SELECT COUNT(DISTINCT(B.NUM_BOL)) AS 'Cantidad'
    FROM BOLETA AS B
    INNER JOIN CLIENTE AS C
      ON B.ID_CLI = C.ID_CLI
	INNER JOIN DETALLE_BOLETA AS D
      ON B.NUM_BOL = D.NUM_BOL
    WHERE B.FECH_BOL BETWEEN fech1 AND fech2;
END $$
delimiter ;

call usp_buscarCantidadVentasEnFechas('2020/11/29', '2020/11/30');

-- Buscar ventas en un rango de fecha
delimiter $$
CREATE PROCEDURE usp_buscarVentasEnFechas(fech1 DATE, fech2 DATE, canti INT)
BEGIN
	-- Nro Boleta, Cliente, Compras, Total
	SELECT B.NUM_BOL AS 'Numero',
           concat(C.NOM_CLI, ' ', C.APE_CLI) AS 'Cliente',
           sum(D.CANT_COMP_BOL) AS 'Compras',
           B.TOT_BOL AS 'Total'
    FROM BOLETA AS B
    INNER JOIN CLIENTE AS C
      ON B.ID_CLI = C.ID_CLI
	INNER JOIN DETALLE_BOLETA AS D
      ON B.NUM_BOL = D.NUM_BOL
    WHERE B.FECH_BOL BETWEEN fech1 AND fech2
    GROUP BY B.NUM_BOL, concat(C.NOM_CLI, ' ', C.APE_CLI)
    LIMIT canti;
END $$
delimiter ;

CALL usp_buscarVentasEnFechas('2020/11/29', '2020/11/30', 2)

-- Historial de Ventas Totales
delimiter $$
CREATE PROCEDURE usp_historialVentasTotales()
BEGIN
	SELECT count(*) AS 'Cantidad Ventas'
    FROM VENTA;
END $$
delimiter ;

CALL usp_historialVentasTotales();

-- Historial de ganancia
delimiter $$
CREATE PROCEDURE usp_historialGanancia()
BEGIN
	SELECT sum(TOT_BOL) AS 'Ganancia Total'
    FROM BOLETA;
END $$
delimiter ;

call usp_historialGanancia();

-- PROCEDURES PARA BUSCAR Y LISTAR BOLETAS

-- Buscar por numero boleta
delimiter $$
CREATE PROCEDURE usp_listadoBoletaPorNumero(num INT)
BEGIN
	SELECT B.NUM_BOL AS 'Num Boleta',
           C.DNI_CLI AS 'DNI',
           B.FECH_BOL AS 'Fecha',
           B.SUB_TOT_BOL AS 'Subtotal',
           B.DESCU_BOL AS 'Descuento',
           B.TOT_BOL AS 'Total'
    FROM BOLETA AS B
    INNER JOIN CLIENTE AS C
      ON B.ID_CLI = C.ID_CLI
	WHERE B.NUM_BOL = num ;
END $$
delimiter ;

CALL usp_listadoBoletaPorNumero(1);

-- Buscar boleta por dni cliente
delimiter $$
CREATE PROCEDURE usp_listadoBoletaPorDNI(dni CHAR(8) )
BEGIN
	SELECT B.NUM_BOL AS 'Num Boleta',
           C.DNI_CLI AS 'DNI',
           B.FECH_BOL AS 'Fecha',
           B.SUB_TOT_BOL AS 'Subtotal',
           B.DESCU_BOL AS 'Descuento',
           B.TOT_BOL AS 'Total'
    FROM BOLETA AS B
    INNER JOIN CLIENTE AS C
      ON B.ID_CLI = C.ID_CLI
	WHERE C.DNI_CLI = dni ;
END $$
delimiter ;

CALL usp_listadoBoletaPorDNI('12345678');

-- Buscar boleta entre rango de fechas
delimiter $$
CREATE PROCEDURE usp_listadoBoletaPorRangoFechas(fech1 DATE, fech2 DATE)
BEGIN
	SELECT B.NUM_BOL AS 'Num Boleta',
           C.DNI_CLI AS 'DNI',
           B.FECH_BOL AS 'Fecha',
           B.SUB_TOT_BOL AS 'Subtotal',
           B.DESCU_BOL AS 'Descuento',
           B.TOT_BOL AS 'Total'
    FROM BOLETA AS B
    INNER JOIN CLIENTE AS C
      ON B.ID_CLI = C.ID_CLI
	WHERE B.FECH_BOL BETWEEN fech1 AND fech2 ;
END $$
delimiter ;

CALL usp_listadoBoletaPorRangoFechas('2020/11/29', '2020/11/30');

-- PROCEDURES PARA LOS DESCUENTOS

-- Aplicar descuento a un producto
delimiter $$
CREATE PROCEDURE usp_aplicarDescuentoProducto(codProd CHAR(8), numTipo INT, descuento DECIMAL(10,2))
BEGIN
	IF (numTipo = 1) THEN  # 1 -> Numerico
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO - descuento
        WHERE COD_PRO = codProd;
	ELSE                   # 2 -> Porcentual
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO * ( 1 -  (descuento/100))
        WHERE COD_PRO = codProd;
	END IF;
END $$
delimiter ;

-- Aplicar descuento a productos de tal tipo
delimiter $$
CREATE PROCEDURE usp_aplicarDescuentoProductoXTipo(tipoDesc INT, tipoProd INT, descuento DECIMAL(10,2))
BEGIN
	IF (tipoDesc = 1) THEN  # 1 -> Numerico
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO - descuento
        WHERE ID_TIPO_PRO = tipoProd;
	ELSE                   # 2 -> Porcentual
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO * ( 1 -  (descuento/100))
        WHERE ID_TIPO_PRO = tipoProd;
	END IF;
END $$
delimiter ;

-- Aplicar descuento a productos de tal marca
delimiter $$
CREATE PROCEDURE usp_aplicarDescuentoProductoXMarca(tipoDesc INT, tipoMarc INT, descuento DECIMAL(10,2))
BEGIN
	IF (tipoDesc = 1) THEN  # 1 -> Numerico
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO - descuento
        WHERE ID_MARC_PRO = tipoMarc;
	ELSE                   # 2 -> Porcentual
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO * ( 1 -  (descuento/100))
        WHERE ID_MARC_PRO = tipoMarc;
	END IF;
END $$
delimiter ;

-- Aplicar descuentos a todos los productos
delimiter $$
CREATE PROCEDURE usp_aplicarDescuentoProductoTodos(tipoDesc INT, descuento DECIMAL(10,2))
BEGIN
	IF (tipoDesc = 1) THEN  # 1 -> Numerico
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO - descuento;
	ELSE                   # 2 -> Porcentual
        UPDATE PRODUCTO
        SET PREC_UNIT_PRO = PREC_UNIT_PRO * ( 1 -  (descuento/100));
	END IF;
END $$
delimiter ;

-- PROCEDURE PARA OBTENER DETALLE DE BOLETA CON DESC DEL PRODUCTO

delimiter $$
CREATE PROCEDURE usp_listaDetalleBolProd(numBol INT)
BEGIN
	SELECT D.NUM_BOL, P.DESC_PRO, P.PREC_UNIT_PRO, D.IMP_PRO, D.CANT_COMP_BOL
    FROM detalle_boleta AS D
	INNER JOIN producto AS P
      ON D.COD_PRO = P.COD_PRO
	WHERE D.NUM_BOL = numBol;
END $$
delimiter ;

CALL usp_listaDetalleBolProd(2)

-- PROCEDURES PARA REPORTE PRODUCTO

delimiter $$
CREATE PROCEDURE usp_ReporteProductoXMarca(codMarca INT)
BEGIN
SELECT
	p.COD_PRO,  
	p.DESC_PRO,
	m.DESC_MARCA,
	T.DESC_TIPO,
	P.STOCK_PRO,
	P.PREC_UNIT_PRO
	FROM PRODUCTO p JOIN  TIPO_PRODUCTO t 
      on p.ID_TIPO_PRO = t.ID_TIPO_PRO 
	join MARCA_PRODUCTO m 
      on p.ID_MARC_PRO = m.ID_MARC_PRO
	WHERE P.ID_MARC_PRO = codMarca AND P.ESTADO = 1;
END $$
delimiter ; 

delimiter $$
CREATE PROCEDURE usp_ReporteProductoXTipo(codTipo INT)
BEGIN
SELECT
	p.COD_PRO,  
	p.DESC_PRO,
	m.DESC_MARCA,
	T.DESC_TIPO,
	P.STOCK_PRO,
	P.PREC_UNIT_PRO
	FROM PRODUCTO p JOIN  TIPO_PRODUCTO t 
      on p.ID_TIPO_PRO = t.ID_TIPO_PRO 
	join MARCA_PRODUCTO m 
      on p.ID_MARC_PRO = m.ID_MARC_PRO
	WHERE P.ID_TIPO_PRO = codTipo AND P.ESTADO = 1;
END $$
delimiter ;

delimiter $$
CREATE PROCEDURE usp_ReporteProductoXTipoYMarca(codTipo INT, codMarca INT)
BEGIN
SELECT
	p.COD_PRO,  
	p.DESC_PRO,
	m.DESC_MARCA,
	T.DESC_TIPO,
	P.STOCK_PRO,
	P.PREC_UNIT_PRO
	FROM PRODUCTO p JOIN  TIPO_PRODUCTO t 
      on p.ID_TIPO_PRO = t.ID_TIPO_PRO 
	join MARCA_PRODUCTO m 
      on p.ID_MARC_PRO = m.ID_MARC_PRO
	WHERE P.ID_TIPO_PRO = codTipo AND P.ID_MARC_PRO = codMarca AND P.ESTADO = 1;
END $$
delimiter ;
