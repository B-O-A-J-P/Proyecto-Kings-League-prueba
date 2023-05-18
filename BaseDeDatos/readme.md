# Levantar base de datos
Para poder levantar la base de datos de forma automatizada, ejecutar "MAC_levantar_base_de_datos.sql" o "WINDOW_levantar_base_de_datos.sql" dependiendo de tu sistema operativo. Tras ejecutar uno de los dos archivos, tendrás la base de datos con todos los objetocs, y un juego de datos.

## Realizar pruebas
En la carpeta "BaseDeDatos/6-Pruebas_de_objetos" dispones de todos los archivos sql para realizar pruebas de los diferentes objetos.

### "1-pruebas_triggers"
En las tablas de la base de datos, todas las primary keys son generadas de manera automática. Debido a esto, para poder ejecutar cada una de las pruebas de los triggers, será necesario volver a ejecutar unos de los archivos "MAC_levantar_base_de_datos.sql" o "WINDOW_levantar_base_de_datos.sql".

### 3-pruebas_procedimientos_paquete
En este directorio tendrás las pruebas para generar el calendario, y la play-off.
Nota: para ejecutar la prueba "2-prueba_calcularClasificacion.sql" tendro del archivo, dispones de un juego de datos, que será necesario ejecutar antes de ejecutar el procedimiento anónimo.
