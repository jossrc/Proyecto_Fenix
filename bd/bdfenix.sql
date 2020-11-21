DROP DATABASE IF EXISTS bdfenix;
CREATE DATABASE bdfenix;

USE bdfenix;

CREATE TABLE VENDEDOR(
  ID_VEND     INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
  ID_CLI     INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  DNI_CLI    CHAR(8)      NOT NULL UNIQUE,
  NOM_CLI    VARCHAR(50)  NOT NULL,
  APE_CLI    VARCHAR(50)  NOT NULL,
  DIREC_CLI  VARCHAR(80)  NOT NULL,
  TELEF_CLI  VARCHAR(15)  NOT NULL UNIQUE,
  ESTADO     INT          NOT NULL
);

CREATE TABLE TIPO_PRODUCTO(
  ID_TIPO_PRO   INT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
  DESC_TIPO     VARCHAR(20)  NOT NULL
);

CREATE TABLE MARCA_PRODUCTO(
  ID_MARC_PRO  INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  DESC_MARCA   VARCHAR(25) NOT NULL
);

CREATE TABLE PRODUCTO(
  COD_PRO        CHAR(8)       NOT NULL PRIMARY KEY,  
  DESC_PRO       VARCHAR(50)   NOT NULL,
  ID_MARC_PRO    INT           NOT NULL,
  ID_TIPO_PRO    INT           NOT NULL,
  STOCK_PRO      INT           NOT NULL CHECK (STOCK_PRO >= 0),
  PREC_UNIT_PRO  DECIMAL(10,2) NOT NULL CHECK (PREC_UNIT_PRO > 0.0),
  
  FOREIGN KEY (ID_TIPO_PRO) REFERENCES TIPO_PRODUCTO(ID_TIPO_PRO), 
  FOREIGN KEY (ID_MARC_PRO) REFERENCES MARCA_PRODUCTO(ID_MARC_PRO)  
);
