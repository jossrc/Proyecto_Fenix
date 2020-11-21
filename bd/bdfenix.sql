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
  ESTADO      INT          NOT NULL
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
