DROP DATABASE IF EXISTS bdfenix;
CREATE DATABASE bdfenix;

USE bdfenix;

CREATE TABLE VENDEDOR(
  ID_VEND     INT          PRIMARY KEY AUTO_INCREMENT,
  DNI_VEND    CHAR(8)      NOT NULL UNIQUE,
  NOM_VEND    VARCHAR(50)  NOT NULL,
  APE_VEND    VARCHAR(50)  NOT NULL,
  DIREC_VEND  VARCHAR(80)  NOT NULL,
  TELEF_VEND  VARCHAR(15)  NOT NULL UNIQUE,
  ESTADO      INT          NOT NULL,
  TIPO        INT          NOT NULL # 0 -> admi , # 1 -> vendedor
);

CREATE TABLE USUARIO(
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
  DIREC_CLI  VARCHAR(80)  NOT NULL,
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

INSERT INTO CLIENTE VALUES (1, '12345678', 'Marcos', 'Szeigfer', 's/n Avebury rd, Londres, Reino Unido', '555-000', 1);
INSERT INTO CLIENTE VALUES (2, '87654321', 'Alan', 'Travis', 's/n Avebury rd, Londres, Reino Unido', '555-001', 1);
INSERT INTO CLIENTE VALUES (3, '00100234', 'James', 'Harker', 's/n Avebury rd, Londres, Reino Unido', '555-002', 1);
INSERT INTO CLIENTE VALUES (4, '17171717', 'Faith', 'Jones', 's/n Avebury rd, Londres, Reino Unido', '555-003', 1);
INSERT INTO CLIENTE VALUES (5, '00100567', 'Diane', 'Leigh', 'Adolfo Alsina 323, C1002ABA CABA, Argentina', '555-004', 0);
INSERT INTO CLIENTE VALUES (6, '00200666', 'Steven', 'Doherty', 'Florida 328, C1005AAH CABA, Argentina', '555-005', 0);

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
	FROM PRODUCTO p JOIN  TIPO_PRODUCTO t on p.ID_TIPO_PRO = t.ID_TIPO_PRO join
    MARCA_PRODUCTO m on p.ID_MARC_PRO = m.ID_MARC_PRO;
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

SELECT * FROM PRODUCTO;

INSERT INTO VENDEDOR VALUES (1, '77416188', 'Jose', 'Atuncar', '701 Brickell Ave #1550, Miami, FL', '111-7777', 1, 0);
INSERT INTO VENDEDOR VALUES (2, '77494174', 'Jose', 'Robles', 'Buenos Aires 322 Sicuani-Ate', '666-5555', 1, 1);

SELECT * FROM VENDEDOR;

