# dv-ds-20202c-g3

Gomez Lucas, Mariana Suarez Del Cerro, Florencia Verratti

# Start App

1. mvn clean install
2. mvn spring-boot:run

# Tests

1. Install Lombok
2. IntelliJ IDEAL: https://projectlombok.org/setup/intellij
2. NetBeans:

# Script Base de datos

CREATE DATABASE `dv-ds-20202c-g3`

// Table (se crea sola cuando corre el proyecto)

DROP IF EXISTS `prendas`;

CREATE TABLE `prendas` (
  `prd_id` bigint NOT NULL AUTO_INCREMENT,
  `prd_description` varchar(255) DEFAULT NULL,
  `prd_precio_base` decimal(19,2) DEFAULT NULL,
  `prd_tipo_prenda` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prd_id`)
)

// Insert de prueba:

INSERT INTO `prendas`
(`prd_id`,
`prd_description`,
`prd_precio_base`,
`prd_tipo_prenda`)
VALUES
(1, 'Camisa Celeste', 10.24, 'CAMISA'),
(2, 'Camisa Blanca', 50.24, 'CAMISA'),
(3, 'Saco Vestir', 20.24, 'SACO'),
(4, 'Pantalon', 100.24, 'PANTALON');
