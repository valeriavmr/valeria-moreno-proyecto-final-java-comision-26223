# Java Backend API - Gestión de Artículos

API REST desarrollada con **Java 17 y Spring Boot** para la gestión de artículos mediante operaciones CRUD (Create, Read, Update, Delete).

La aplicación permite crear, consultar, actualizar y eliminar artículos, almacenando la información en una base de datos MySQL mediante Spring Data JPA.

## Tecnologías utilizadas

- **Java 17:** lenguaje de programación.
- **Spring Boot:** framework para el desarrollo de la aplicación.
- **Spring Web:** creación de endpoints REST.
- **Spring Data JPA:** persistencia y acceso a datos.
- **Hibernate:** implementación ORM utilizada por JPA.
- **MySQL:** sistema de gestión de bases de datos.

## Estructura del proyecto

El proyecto sigue una arquitectura por capas:

- **Model:** contiene la entidad `Articulo`.
- **Repository:** interfaz encargada del acceso a la base de datos mediante Spring Data JPA.
- **Service:** contiene la lógica de negocio y las operaciones sobre los artículos.
- **Controller:** expone los endpoints REST y gestiona las solicitudes HTTP.

## Modelo de datos

La entidad `Articulo` contiene los siguientes atributos:

| Campo | Tipo | Descripción |
|---|---|---|
| id | Long | Identificador único autogenerado. |
| nombre | String | Nombre del artículo. |
| precio | Double | Precio del artículo. |
| cantidadStock | int | Cantidad disponible en stock. |

## Configuración de la base de datos

La aplicación utiliza MySQL y requiere una base de datos llamada `techlabdb`.

Primero, crea la base de datos ejecutando el archivo .sql llamado `techlabdb.sql` en tu motor de base de datos

Luego, configura las credenciales de conexión en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/techlabdb
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Reemplaza `TU_USUARIO` y `TU_PASSWORD` por las credenciales correspondientes a tu instalación de MySQL.

## Instalación y ejecución

1. Clonar el repositorio:

```bash
git clone https://github.com/valeriavmr/valeria-moreno-proyecto-final-java-comision-26223.git
```

2. Ingresar al directorio del proyecto:

```bash
cd nombre-del-proyecto
```

3. Configurar las credenciales de MySQL en `application.properties`.

4. Ejecutar la aplicación desde el IDE o mediante Maven:

```bash
./mvnw spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

La API estará disponible por defecto en:

`http://localhost:8080`

## Endpoints disponibles

La API utiliza la ruta base `/api/articulos`.

| Método HTTP | Endpoint | Descripción |
|---|---|---|
| GET | `/api/articulos` | Obtiene todos los artículos. |
| GET | `/api/articulos/{id}` | Obtiene un artículo por su ID. |
| POST | `/api/articulos` | Crea un nuevo artículo. |
| PUT | `/api/articulos/{id}` | Actualiza un artículo existente. |
| DELETE | `/api/articulos/{id}` | Elimina un artículo. |

## Ejemplos de uso

### Crear un artículo

**POST** `/api/articulos`

Body (JSON):

```json
{
  "nombre": "Teclado mecánico",
  "precio": 45000.0,
  "cantidadStock": 15
}
```

### Consultar todos los artículos

**GET** `/api/articulos`

### Consultar un artículo por ID

**GET** `/api/articulos/1`

### Actualizar un artículo

**PUT** `/api/articulos/1`

Body (JSON):

```json
{
  "nombre": "Teclado mecánico RGB",
  "precio": 52000.0,
  "cantidadStock": 20
}
```

### Eliminar un artículo

**DELETE** `/api/articulos/1`

## Manejo de respuestas HTTP

| Código | Descripción |
|---|---|
| 200 OK | Solicitud procesada correctamente. |
| 201 Created | Recurso creado correctamente. |
| 204 No Content | Recurso eliminado correctamente. |
| 404 Not Found | Artículo no encontrado. |

### Demostración grabada
https://youtu.be/4ojk0eZbj4Q

**Creador** @valeriavmr
