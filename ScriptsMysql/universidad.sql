use universidad;
CREATE TABLE `Asignatura` ( 
   `id` BIGINT NOT NULL,
   `nombre` VARCHAR(200) NOT NULL,
   `creditos` INT(10) NOT NULL,
   `profesor_id` BIGINT NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `Profesor` ( 
   `id` BIGINT NOT NULL,
   `nombre` VARCHAR(25) NOT NULL,
   `apellido_pat` VARCHAR(50) NOT NULL,
   `apellido_mat` VARCHAR(50) NOT NULL,
   `ciudad` VARCHAR(50) NOT NULL,
   `direccion` VARCHAR(50) NOT NULL,
   `telefono` VARCHAR(20),
   `fecha_nacimiento` DATE,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `Periodo_escolar` ( 
   `id` BIGINT NOT NULL,
   `periodo_inicio` INT(4) NOT NULL,
   `periodo_fin` INT(4) NOT NULL,
    PRIMARY KEY (
   `id`
    )
);
CREATE TABLE `Matricula` ( 
   `identificacion_alumno` BIGINT NOT NULL,
   `nombre_alumno` VARCHAR(200),
   `periodo_escolar_id` BIGINT NOT NULL,
   `asignatura_id` BIGINT NOT NULL,
    PRIMARY KEY (
   `identificacion_alumno`,
   `periodo_escolar_id`,
   `asignatura_id`
    )
);
ALTER TABLE `Asignatura` 
  ADD CONSTRAINT `fk_profesor`
  FOREIGN KEY ( 
   `profesor_id`
)   REFERENCES `Profesor`( 
   `id`
) ;


ALTER TABLE `Matricula` 
  ADD CONSTRAINT `fk_periodo_escolar`
  FOREIGN KEY ( 
   `periodo_escolar_id`
)   REFERENCES `Periodo_escolar`( 
   `id`
) ;


ALTER TABLE `Matricula` 
  ADD CONSTRAINT `fk_asignatura`
  FOREIGN KEY ( 
   `asignatura_id`
)   REFERENCES `Asignatura`( 
   `id`
) ;


INSERT INTO `universidad`.`profesor`
(`id`,
`nombre`,
`apellido_pat`,
`apellido_mat`,
`ciudad`,
`direccion`,
`telefono`,
`fecha_nacimiento`)
VALUES
(1,
'Alfredo',
'Valdez',
'Valdez',
'Santiago',
'Santiago #123',
'12345678',
sysdate());

INSERT INTO `universidad`.`profesor`
(`id`,
`nombre`,
`apellido_pat`,
`apellido_mat`,
`ciudad`,
`direccion`,
`telefono`,
`fecha_nacimiento`)
VALUES
(2,
'Antonela',
'Rojas',
'Valdez',
'Valparaiso',
'Madrid #124',
'345673457',
sysdate());

INSERT INTO `universidad`.`periodo_escolar`
(`id`,
`periodo_inicio`,
`periodo_fin`)
VALUES
(1,
2021,
2022);

INSERT INTO `universidad`.`asignatura`
(`id`,
`nombre`,
`creditos`,
`profesor_id`)
VALUES
(2,
'Filosofía',
10,
1);


select * from profesor;
select * from periodo_escolar;
select * from asignatura;
select * from matricula;