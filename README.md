Prueba Tecnica Daniel Casallas

Esta aplicación es una ApiRestFull y tiene su integración los servicios de la Api https://dummy.restapiexample.com/api/v1/employees, https://dummy.restapiexample.com/api/v1/employee/1 la cual tiene como finalidad realizar consultas a EndPoints.

Fue realizado bajo la arquitectura de MicroServicios, patron de diseño MVC tambien con el uso de Lambdas, es decir; no es una Api Monolitica, si un servicio falla, seguirá funcionando con normalidad, esta prueba esta realizada con el lenguaje de programación Java en su versión Java 8 y su Framework SpringBoot, con su gestor de dependencias Gradle, haciendo uso de una base de datos H2 para su correcto funcionamiento. Para poder correr este proyecto de manera local, es necesario contar con el JDK de Java, gestor de construcción y desempaquetamiento de librerias Maven, variables de entorno y un compilador de código (Intellij fue usado para la creación de esta prueba).

-- BACK END --

Instalación JDK

Es necesario, instalar el JDK para poder correr aplicaciones basadas en Java. La instalación es la misma para equipos de 35 o 64bits, relaciono los links del instalador.

Link Java Equipos 32 Bits https://www.java.com/es/download/ie_manual.jsp

Link Java Equipos 64 Bits https://www.java.com/en/download/

1). Una vez se haya descargado el archivo, lo abrimos y le damos en el botón instalar. 2). Luego le damos en siguiente y en siguiente. 3). Una vez terminado este proceso, ubicamos la ruta del archivo donde se descargó (Generalmente se encuentra en C:\Program Files\Java). 4). Alli abrimos la carpeta la cual inicia con "JDK" 5). Ingresamos a la carpeta y nos ubicamos en la carpeta llamada "BIN" (No cerrar la ventana)

Creación variable de entorno

La variable de entorno, nos permite abrir cualquier aplicación Java, ya que esta variable de entorno, la comprendera el sistema, como ejecutable para archivos con extencion .jar y/o aplicaciones Java.

1). Buscamos en el explorador de Windows "Variables de entorno" y nos aparecera como sugerencia "Editar las variables de entorno del sistema" 2). Seleccionamos "Editar las variables de entorno del sistema", alli se nos abrira una ventana con el nombre "Propiedades del sistema" 3). Dentro de esa ventana ubicamos el botón y/o opción con el nombre "Variables de entorno" 4). Una vez seleccionada esta opción, se nos abre otra ventana llamada Variables de entorno. 5). Nos ubicamos en "Variables del sistema" y le damos a la botón y/o opción "Nueva" 6). Se nos abrira una nueva ventana "Nueva variable del sistema", con dos campos "Nombre de variable" y "Valor de variable". 7). En el campo "Nombre de la Variable" pondremos "JAVA_HOME", en mayusculas y con barra al piso. 8). En el campo "Valor de la Variable" pondremos el link del archivo donde se instalo el JDK (Tomar como sugerencia el punto 5 de la insalación de JDK)"C:\Program Files\Java\jdk1.8.0_311\bin", esto la URL o ruta de instalación completa. 9). Le damos en todas las opciones de aceptar.

Validación Instalación
1). Si todos los pasos anterior se hicieron de manera correcta, a continuación nos ubicamos en el Simbolo de sistema (CMD). 2). Para abrir el CMD podemos pulsar las teclas (Windows + R) y alli pondremos CMD. 3). Una vez abierto CMD, pondremos el siguiente comando: java -version y pulsaremos enter. 4). Este comando una vez ejecutado, nos arrojara en pantalla la versión del Java Instalado.

-- FRONT END --

Instalación Node.js

Link de instalación https://nodejs.org/es/download
Es necesario instalar node.js para poder levantar nuestro front end y hacer comandos tipo npm, su instalación es fácil es solamente dale siguiente a todas las ventanas que se nos aparezcan. Para poder verificar que fue exitoso su instalación, abrimos la ventana de comandos (CMD), y ejecutamos el siguiente comando: node -v

---- Instaladores de desarrollo ----

Una instalado el JDK y Gradle, podemos descargar nuestro compilador de código de preferencia, recomendable (Intellij).

Link de instalación https://www.jetbrains.com/idea/download/#section=windows

¡ DESCARGAR LA VERSIÓN COMMUNITY EDITION !, es la versión gratuita.

Link de instalación Visual studio code.

https://code.visualstudio.com/

Una vez instalado los instaladores y/o programas de desarrollo, procederemos a levantar los ambientes.

-- Back End --

Para ejecutar el ambiente de desarrollo del BackEnd, realizado en Java, realizamos los siguientes pasos.

1). Nos ubicamos en la raiz del proyecto y ubicamos la carpeta llamada "target", alli ubicaremos el archivo con la extensión .war. 2). Abrimos la ventana de comandos (CMD) y navegamos hasta la raiz donde se encuentra el archivo con la version .war y ejecutamos el siguiente comando: java -jar test-0.0.1-SNAPSHOT.WAR Nota: Siempre se pone el nombre completo con la extensión. 3). Si todo funciona correctamente se nos ejecutara en la ventana de comandos el logo de Spring, y al finalizar nos indicara en que puerto se ejecuto nuestro BackEnd, en el proyecto se configuro el port:8081

-- Front End --

Para ejecutar nuestro FrontEnd, debemos abrir nuestro visual studio code, y abrimos la carpeta donde se encuentra descargado nuestro frontend.

1). Abrimos una nueva terminal, para esto nos ubicamos en terminal y en new terminal. 2). Alli ponemos el comando ng serve -o ó el comando npm-start, y este se nos abrira automaticamente en el port:4200. Nota: Si el comando npm-start o ng serve -o, nos presenta error, haremos lo siguiente:

Buscamos en nuestro windows con las teclas Windows + S, y en el buscador ponemos: node.js command prompt y lo ejecutamos como administrador
Una vez ubicamos ahi procederemos a instalar nuestro angular con el siguiente comando: npm install -g @angular/cli
Con esto ya podremos ejecutar los comandos respectivos para ejecutar nuestro FrontEnd.
Ya con esto podremos ejecutar las acciones respectivas a la prueba tecnica brindada con su respectivo funcionamiento.

La colección de POSTMAN, se encuentran el puerto de dónde se encuentra desplegado el servicio actualmente en la nube.

Este es un ejemplo haciendo peticiones de manera local.

Ejemplo: http://localhost:8081/findemployeebyid/1

IP: localhost o (la ip de tu equipo) PUERTO: :8081 NOMBRE SERVICIO: findEmployeById PETICIÓN: findemployeebyid PARAMETRO: 1 (o id empleado a buscar)

Ejemplo: http://localhost:8081/getemployee

IP: localhost o (la ip de tu equipo) PUERTO: :8081 NOMBRE SERVICIO: getEmploye PETICIÓN: getemployee
