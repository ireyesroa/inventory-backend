
# Documentación de la Estructura de la Base de Datos

1. Introducción
Esta documentación proporciona una descripción detallada de la estructura de la base de datos utilizada por [inventory-back]. Incluye detalles sobre las tablas, relaciones entre ellas, y cómo se almacenan y acceden a los datos.

2. Descripción General de la Base de Datos
Nombre de la Base de Datos: [inventory]
Sistema de Gestión de Bases de Datos (SGBD): [PostgreSQL]
Versión del SGBD: [3.5]

3. Estructura de la Base de Datos
3.1 Tablas
3.1.1 3.1.1 Tabla: categories
Descripción: Almacena información sobre categorías de productos.
Columnas:
id (INTEGER, PK): Identificador único de la categoría.
category_name (VARCHAR(50)): Nombre de la categoría.
description (TEXT): Descripción de la categoría.

3.1.2 Tabla: suppliers
Descripción: Almacena información sobre los proveedores.
Columnas:
id (INTEGER, PK): Identificador único del proveedor.
company_name (VARCHAR(50)): Nombre del proveedor.
contact_name (VARCHAR(70)): Información de contacto del proveedor.
address (VARCHAR(100)): Dirección de la empresa.
city (VARCHAR(30)): ciudad de la empresa.
country (VARCHAR(30)): país de la empresa.
phone (VARCHAR(30)): phone de la empresa.
postal_code (VARCHAR(30)): codigo postal de la empresa.

3.1.3 Tabla: employees
Descripción: Almacena información sobre los empleados.
Columnas:
id (INTEGER, PK): Identificador único del empleado.
name (VARCHAR(70)): nombre del empleado.
address (VARCHAR(100)): dirección del empleado.
email (VARCHAR(100)): Correo electrónico del empleado.
phone (VARCHAR(15)): Número de teléfono del empleado.

3.1.4 Tabla: customers
Descripción: Almacena información sobre los clientes.
Columnas:
id (INTEGER, PK): Identificador único del cliente.
name (VARCHAR(70)): Nombre del cliente.
email (VARCHAR(100)): Correo electrónico del cliente.
phone (VARCHAR(15)): Número de teléfono del cliente.
address (VARCHAR(100)): Dirección del cliente.

3.1.5 Tabla: products
Descripción: Almacena información sobre los productos.
Columnas:
id (INTEGER, PK): Identificador único del producto.
product_name (VARCHAR(30)): Nombre del producto.
discontinued (BOOLEAN): Si el producto esta descontinuado.
picture (VARCHAR(200)): imagen del producto
sku (VARCHAR(100) U): código único de referencia del producto
unit_in_stock (INTEGER): Cantidad en stock del producto 
unit_price (DECIMAL): Precio del producto.
category_id (INTEGER, FK): Referencia a la columna id en categories.
supplier_id (INTEGER, FK): Referencia a la columna id en suppliers.

3.1.6 Tabla: orders
Descripción: Almacena información sobre las órdenes.
Columnas:
id (INTEGER, PK): Identificador único de la orden.
customer_id (INTEGER, FK): Referencia a la columna id en customers.
employee_id (INTEGER, FK): Referencia a la columna id en employees.
order_date (TIMESTAMP): Fecha y hora en que se realizó la orden.
ship_address (VARCHAR(100)): Dirección de envio.
ship_city (VARCHAR(30)): ciudad de envio.
ship_country (VARCHAR(30)): pais de envio.
ship_name (VARCHAR(70)): nombre de envio.

3.1.7 Tabla: order_details
Descripción: Almacena los detalles de los productos incluidos en cada orden.
Columnas:
order_id (INTEGER, PK): Identificador único de la orden.
product_id (INTEGER, PK): Identificador único de products.
quantity (INTEGER): Cantidad del producto en la orden.
unit_price (DECIMAL): Precio unitario del producto en la orden.


3.2 Relaciones Entre Tablas
3.2.1 Relación entre products y categories
Descripción: Cada producto pertenece a una categoría.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en products:
category_id (INTEGER, FK): Referencia a categories(id).

3.2.2 Relación entre products y suppliers
Descripción: Cada producto es suministrado por un proveedor.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en products:
supplier_id (INTEGER, FK): Referencia a suppliers(id).

3.2.3 Relación entre orders y customers
Descripción: Cada orden es realizada por un cliente.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en orders:
customer_id (INTEGER, FK): Referencia a customers(id).

3.2.4 Relación entre orders y employees
Descripción: Cada orden es gestionada por un empleado.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en orders:
employee_id (INTEGER, FK): Referencia a employees(id).

3.2.5 Relación entre order_details y orders
Descripción: Cada detalle de una orden está asociado a una orden específica.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en order_details:
order_id (INTEGER, PK): Referencia a orders(id).

3.2.6 Relación entre order_details y products
Descripción: Cada detalle de una orden corresponde a un producto específico.
Tipo de Relación: Muchos a Uno (Many-to-One)
Columna en order_details:
product_id (INTEGER, PK): Referencia a products(id).


4. Acceso a los Datos
4.1 Consultas Básicas
4.1.1 Obtener Todos los Productos
sql
Copiar código
SELECT * FROM products;
4.1.2 Obtener un Producto por ID
sql
Copiar código
SELECT * FROM products WHERE id = ?;
4.1.3 Obtener una Órden por ID
sql
Copiar código
SELECT * FROM orders WHERE order_id = ?;


4.2 Inserción de Datos
4.2.1 Insertar un Nuevo Producto
sql
Copiar código
INSERT INTO products (product_id, product_name, sku, discontinued, picture, unit_in_stock, unit_price, category_id, supplier_id) 
VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);

4.2.1 Insertar una Nueva Orden
sql
Copiar código
INSERT INTO orders (order_id, order_date, ship_address, ship_city, ship_country, ship_name, customer_id, employee_id) 
VALUES (?, ?, ?, ?, ?, ?, ?, ?);

5. Administración de Datos

5.1 Índices
Tabla products: Índice en la columna product_name para mejorar la búsqueda de productos.
Tabla orders: Índice en la columna order_date para consultas basadas en fechas.


5.2 Seguridad
Acceso a la Base de Datos: Configura permisos como admin en PostgreSQL para garantizar que solo los usuarios autorizados puedan acceder y modificar los datos.

#####################################################################

Documentación de la API REST
1. Introducción
Esta documentación describe la API REST para gestionar los recursos relacionados con productos, órdenes, detalles de órdenes, clientes, empleados, proveedores y categorías. La API sigue los principios RESTful y proporciona algunas operaciones básicas para cada recurso.


2. Recursos de la API 
Cada recurso está asociado a un conjunto de endpoints que permiten realizar operaciones sobre él. Los recursos y sus operaciones se detallan a continuación.

2.1 Productos (/products)
Descripción
El recurso products representa los productos disponibles en el sistema.

Operaciones

GET /products?page={1}&size={10}
Descripción: Obtiene una lista de todos los productos paginados.
Respuesta: 200 OK con una lista de productos en formato JSON.

GET /products/{id}
Descripción: Obtiene los detalles de un producto específico por su ID.
Parámetros de Ruta:
id: ID del producto.
Respuesta: 200 OK con los detalles del producto. 404 Not Found si el producto no existe.

POST /product
Descripción: Crea un nuevo producto.
Cuerpo de Solicitud:
JSON con los detalles del producto.
Respuesta: 201 Created con la información del producto creado.


2.2 Órdenes (/orders)
Descripción
El recurso orders representa las órdenes realizadas en el sistema.

Operaciones

GET /orders?page={1}&size={10}
Descripción: Obtiene una lista de todas las órdenes paginadas.
Respuesta: 200 OK con una lista de órdenes en formato JSON.

GET /orders/{id}
Descripción: Obtiene los detalles de una orden específica por su ID.
Parámetros de Ruta:
id: ID de la orden.
Respuesta: 200 OK con los detalles de la orden. 404 Not Found si la orden no existe.

POST /orders
Descripción: Crea una nueva orden.
Cuerpo de Solicitud de la orden y sus detalles:
JSON con los detalles de la orden.
Respuesta: 201 Created con la información de la orden creada.


2.3 Detalles de Órdenes (/order_details)
Descripción
El recurso order_details representa los detalles de los productos en una orden específica.

Operaciones

GET /order_details/{id}
Descripción: Obtiene los detalles de una orden específica por su ID.
Parámetros de Ruta:
id: ID de la orden.
Respuesta: 200 OK con los detalles de la orden. 404 Not Found si el detalle no existe.


2.4 Categorias (/categories)
Descripción
El recurso categories representa las categorias de los productos.

Operaciones

GET /categories?page={1}&size={10}
Descripción: Obtiene todas las categorias paginadas.
Respuesta: 200 OK con una lista de órdenes en formato JSON.

GET /categories/{id}
Descripción:  Obtiene las categorias por su ID.
Parámetros de Ruta:
id: ID de categoria.
Respuesta: 200 OK con los detalles de la categoria. 404 Not Found si no existe.

2.5 Empleados (/employees)
Descripción
El recurso employees representa los empleados.

Operaciones

GET /employees?page={1}&size={10}
Descripción: Obtiene todos los empleados paginados.
Respuesta: 200 OK con una lista de empleados en formato JSON.

GET /employees/{id}
Descripción:  Obtiene el empleado por su ID.
Parámetros de Ruta:
id: ID de empleado.
Respuesta: 200 OK con los detalles del empleado. 404 Not Found si no existe.



2.6 Proveedores (/suppliers)
Descripción
El recurso suppliers representa los proveedores de los productos.

Operaciones

GET /suppliers?page={1}&size={10}
Descripción: Obtiene todos los proveedores paginados.
Respuesta: 200 OK con una lista de proveedores en formato JSON.

GET /suppliers/{id}
Descripción:  Obtiene el proveedor por su ID.
Parámetros de Ruta:
id: ID del proveedor.
Respuesta: 200 OK con los detalles del proveedor. 404 Not Found si no existe.


Mas detalle de la documentación entra a:
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-docs

usuario: inventoryapp
contraseña: MjAyNDA5MDQ=










## Acknowledgements

 - [Awesome README](https://github.com/ireyesroa/inventory-backend/master)


