# RetoJDBCMaven

## Descripción
Este proyecto fue desarrollado como parte del programa de formación Misión Tic (Ciclo 2). Es una aplicación de escritorio desarrollada en Java utilizando el patrón MVC y Maven como gestor de dependencias. Permite la gestión de productos y proveedores, así como la generación de reportes y la conexión a una base de datos MySQL. Incluye una interfaz gráfica para facilitar la administración de inventario y ventas.

## ¿Qué hace el programa?
- Permite registrar, editar, buscar y eliminar productos y proveedores.
- Gestiona la información de inventario y ventas.
- Genera reportes de productos y proveedores.
- Utiliza una base de datos MySQL para almacenar la información.
- Exporta datos a archivos Excel.

## ¿Cómo ejecutar el programa?
1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener instalado Java (JDK 8 o superior) y Maven.
3. Configura una base de datos MySQL y actualiza las credenciales en `src/main/java/Model/dbData.java` si es necesario.
4. Ejecuta el siguiente comando en la raíz del proyecto para compilarlo:
	```bash
	mvn clean package
	```
5. Ejecuta la aplicación con:
	```bash
	java -jar target/RetoJDBCMaven-1.0-SNAPSHOT.jar
	```

## Dependencias principales
- Apache POI (para manejo de archivos Excel)
- MySQL Connector/J (para conexión a la base de datos)
- JFreeChart (para generación de gráficos)

## Autor
Proyecto desarrollado por manuel y jotarlo.