# CRUD de Tareas con Spring Boot y Clean Architecture

Este proyecto es un CRUD de tareas desarrollado con **Spring Boot**, cuyo objetivo principal es poner en práctica la **Clean Architecture**, buenas prácticas de diseño y una correcta separación de responsabilidades.  
Incluye autenticación y autorización mediante **Spring Security + JWT**, migraciones de base de datos con **Flyway** y ejecución del entorno usando **Docker y Docker Compose**.

## Tecnologías utilizadas

- Kotlin 
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Flyway
- JPA / Hibernate
- Docker
- Docker Compose
- Base de datos relacional

## Arquitectura

El proyecto sigue los principios de **Clean Architecture**, separando el código en capas bien definidas.

### Estructura del proyecto

```
src/main/java
├── application
│   ├── dto
│   ├── usecase
│   └── service
├── domain
│   ├── model
│   └── repository
└── infrastructure
    ├── config
    ├── controller
    ├── persistence
    ├── security
    └── mapper
```

### Descripción de capas

- **Domain**
    - Contiene las entidades del negocio y las interfaces de repositorio.
    - No depende de ningún framework.

- **Application**
    - Contiene los casos de uso y la lógica de aplicación.
    - Orquesta el dominio sin conocer detalles de infraestructura.

- **Infrastructure**
    - Implementa detalles técnicos como controladores REST, seguridad, persistencia y configuración.
    - Depende de Spring Boot y otras librerías externas.

## Seguridad

La seguridad está implementada con **Spring Security** y **JWT**.

- Autenticación basada en tokens JWT.
- Todas las rutas de tareas requieren autenticación.
- Existe un usuario por defecto para facilitar las pruebas.

## Migraciones de base de datos

El proyecto utiliza **Flyway** para el versionamiento de la base de datos.

- Las migraciones se ejecutan automáticamente al iniciar la aplicación.
- Scripts ubicados en `src/main/resources/db/migration`.

## Ejecución del proyecto con Docker

### Requisitos

- Docker
- Docker Compose

### Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio
```

### Levantar el entorno

```bash
docker compose up --build
```

La aplicación estará disponible en:

```
http://localhost:8080
```

## Endpoints de autenticación

### Registrar usuario

POST
```
http://localhost:8080/api/v1/auth/register
```

### Login

POST
```
http://localhost:8080/api/v1/auth/login
```

Ambos endpoints retornan un **JWT** que debe enviarse en el header:

```
Authorization: Bearer <token>
```

## Endpoints de tareas (requieren autenticación)

### Obtener todas las tareas

GET
```
http://localhost:8080/api/v1/tasks
```

### Obtener tarea por ID

GET
```
http://localhost:8080/api/v1/tasks/5
```

### Crear tarea

POST
```
http://localhost:8080/api/v1/tasks
```

Body:
```json
{
  "title": "Programar",
  "description": "esese",
  "completed": true,
  "priority": "alta",
  "due_date": "2026-01-19",
  "user_id": 2
}
```

### Actualizar tarea

PUT
```
http://localhost:8080/api/v1/tasks/5
```

Body:
```json
{
  "title": "Programar",
  "description": "ee",
  "completed": true,
  "priority": "alta",
  "due_date": "2026-01-19",
  "user_id": 2
}
```

### Eliminar tarea

DELETE
```
http://localhost:8080/api/v1/tasks/5
```

## Pruebas

Se recomienda usar Postman o Insomnia y enviar el token JWT en cada request protegido.

## Capturas de pantalla

Agregar aquí imágenes del funcionamiento del proyecto.

## Autor

Proyecto desarrollado con fines educativos para practicar Clean Architecture, seguridad con JWT y Docker en Spring Boot.
