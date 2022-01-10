Para poder correr la APP  se necesita en 

Primer lugar:

Motor de base de datos Mysql encendido y funcionando en el puerto 3306 (sql se puede descargar desde la siguiente web https://dev.mysql.com/downloads/mysql/)
(crear usuario reto con password reto.1234 el mismo tiene que contar com privilegios en sobre la base de datos)

Servidor Apache tomcat ( en su defecto usar IDE Spring tools con servidor tomcat embebido )

Segundo paso:

Agregar al motor mysql la base de datos reto.sql
Agregar registros user.sql y loans.sql

Tercer paso:
se puede seguir dos metodos:

Descargar el archivo .war y agregarlo a la carpeta webApps de su servidor Tomcat local.

Descargar el proyecto y ejecutarlo en un IDE Spring Tools con el servidor Tomcat embedido

