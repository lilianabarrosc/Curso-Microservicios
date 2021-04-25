# Curso-Microservicios
Micro servicios en spring boot

##Caso: Universidad
En la carpeta ScriptsMysql se puede encontrar el esquema de datos creados para base de datos mysql donde se registran las matriculas y tambien se puede encontrar un archivo con el contenido
del documento Alumno, que es posible registrar en mongoDB.

##micro servicios:

--Alumnos: crud de alumnos matriculados en la universidad
--Inscripciones: inscripción de alumnos a un determinado curso para x periodo.

##Se crean los microservicios de:
###1.- alumnos: microservicios con bd en mongo, se registra en eureka y posee autenticacion
###2.- matricula: microservicio de matriculas, se registra en eureka y posee autenticacion
###3.- API composer: contiene configuración obtenida para ereka desde un repositorio remoto, levantar este servicio primero que eureka y los demás microservicios
###4.- eureka: microservicio de servidor eureka
###5.- zuul: micorservicio de servidor zuul perimetral donde enruta los servicios de alumnos, matricula y autenticacion.
###6.- UAA: microservicio de autenticacion.

## API composer
Se configura un api composer basado en API Facade Composition, y además contiene mensajes asincronos con RabbitMQ

###1.- apicomposer: microservicio que usa los recursos de alumnos y matriculas para listar matriculas y alumnos.
###2.- alumnoComposer: microservicios con bd en mongo, se registra en eureka
###3.- matriculaCOmposer: microservicio de matriculas, se registra en eureka


