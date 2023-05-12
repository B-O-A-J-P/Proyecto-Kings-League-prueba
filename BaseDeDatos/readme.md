Ejecuta scriptkings_league.sql en el orden que está escrito
En scriptkings_league.sql hay dos versiones, una para windows, y otra para MAC, solo ejecuta la parte donde se indica la versión correspondiente a tu sistema operativo. 
Si tienes un sistema operativo Windows, ejecuta la versión para Windows
Si tienes un sistema operativo MAC, ejecuta la versión para MAC.
Estas dos versiones en ,scriptkings_league.sql, se diferencian con un comentario donde empieza la parte de windows, y donde empieza la parte de MAC
(--Windows o --MAC)
Es importante seguir las instrucciones y verificar la versión correcta antes de ejecutar cualquier parte.
el proyecto deberá ser almacenado en la carpeta de documentos 

Para generar el calendario puedes serguir estos pasos:
- 1 Tras construir la base de datos ejecutar las inserts en el archivo "dummy-inserts.sql" (si has ejecutado todo el script "scriptkings_league.sql" no hace falta hacer este paso).
- 2 Llamar el procedimiento "generar_calendario", almacenado dentro del paquete "utilidades_calendario" -> utilidades_calendario.generar_calendario('19:00', 'En el fin del mundo', 0);

Para generar el playoff
- 1 Es necesario haber hecho los pasos anteriores
- 2 Ejecutar las inserts del archivo "dummy-inserts-clasificaiones.sql"
- 3 Llamar el procedimiento "generar_playoff", almacenado dentro del paquete "utilidades_calendario" -> utilidades_calendario.generar_playoff('12:00', 0);
