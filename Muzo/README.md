# Proyecto Muzo
- JUAN FELIPE VIVAS
- DANIEL ESTEBAN PEREZ
- DANIEL FERNANDO MORENO
- JUAN FRANCISCO TERAN
# UTLIZAMOS LO SIGUIENTE  PARA ARRANCAR LA BASE DE DATOS (DOCKER):
- Como primer paso descargamos la imagen de MySQL:
docker pull mysql
- Luego para correr el contenedor utilizamos el siguiente comando:
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:latest
- Luego de correr la bases de datos ejecutamos el proyecto con el siguiente comando, recuerda que debes estar en la carpeta del proyecto:
mvn spring-boot:run