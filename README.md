# Proyecto Demo – API de Estudiantes (Spring Boot)

Este proyecto es un ejemplo **básico** de una API REST construida con **Spring Boot**, usando **Spring Web** y **Spring Data JPA**. Su objetivo es entender cómo se conectan entre sí el **modelo**, el **repositorio** y el **controlador**.

---

## 1. Modelo (`Estudiante`)

El modelo representa los datos principales del sistema. En este caso, un **Estudiante**.

### ¿Qué es el modelo?

Es la clase que define **qué información se guarda** y **cómo se estructura** dentro de la base de datos.

### Puntos clave del modelo

* Está anotado con `@Entity`, lo que indica que es una **entidad JPA**.
* Tiene un identificador único con `@Id`.
* Debe tener un **constructor vacío**, obligatorio para Hibernate.
* No debe usar campos `final`, porque JPA necesita modificarlos internamente.

Ejemplo conceptual:

* `id`: identifica al estudiante
* `nombre`: nombre del estudiante
* `carrera`: programa académico

El modelo **no maneja peticiones HTTP ni acceso directo a la base de datos**, solo representa datos.

---

## 2. Repositorio (`RepositorioEstudiante`)

El repositorio es la capa que se encarga de **hablar con la base de datos**.

### ¿Qué hace el repositorio?

* Guarda entidades
* Busca entidades
* Elimina entidades
* Verifica si una entidad existe

Todo esto **sin escribir SQL**, gracias a Spring Data JPA.

### Características importantes

* Extiende `JpaRepository<Estudiante, Long>`
* Spring genera automáticamente la implementación
* Proporciona métodos como:

  * `findAll()`
  * `save()`
  * `existsById()`

El repositorio **solo trabaja con entidades**, no con lógica de negocio ni con HTTP.

---

## 3. Controlador (`EstudianteController`)

El controlador es la capa que **expone la API al exterior**.

### ¿Qué hace el controlador?

* Recibe peticiones HTTP
* Llama al repositorio
* Devuelve respuestas HTTP

Está anotado con `@RestController`, lo que indica que devuelve datos (JSON) y no vistas.

### Endpoints principales

* `GET /estudiantes`

  * Devuelve la lista de todos los estudiantes

* `POST /estudiantes`

  * Recibe un estudiante en formato JSON
  * Verifica si ya existe
  * Lo guarda en la base de datos

El controlador **no sabe cómo se guardan los datos**, solo delega esa responsabilidad al repositorio.

---

## 4. Flujo general de la aplicación

1. El cliente envía una petición HTTP
2. El controlador recibe la petición
3. El controlador llama al repositorio
4. El repositorio interactúa con la base de datos usando el modelo
5. El controlador devuelve la respuesta al cliente

Cada capa tiene una **responsabilidad clara**, lo que hace el código más ordenado y mantenible.

---

## 5. Aprendizajes clave

* JPA exige que las entidades cumplan reglas específicas (`@Entity`, `@Id`, constructor vacío).
* El repositorio simplifica el acceso a la base de datos.
* El controlador se encarga exclusivamente de la comunicación HTTP.
* Separar responsabilidades evita errores y hace el sistema más fácil de entender.

Este pequeño ejercicio es una base sólida para entender cómo funciona una aplicación REST sencilla con Spring Boot.
