# 🚀 User Management API - Spring Boot

Este proyecto es una **API REST para la gestión de usuarios** desarrollada con **Spring Boot**, **Spring Data JPA** y **H2/MySQL**.

## 📌 Características del Proyecto

✅ CRUD completo para usuarios (GET, POST, PUT, DELETE).  
✅ Uso de **Spring Boot** con arquitectura **MVC** (Controller, Service, Repository).  
✅ **Validaciones** de datos con @Valid y spring-boot-starter-validation.  
✅ Manejo de **excepciones globales** con @ExceptionHandler.  
✅ Uso de **H2 en modo persistente** o **MySQL** como base de datos.  
✅ Documentado para pruebas con **Postman**.  

---

## 📂 Estructura del Proyecto

src/main/java/com/alvaro/users  
 ├── controller/    # Controlador REST (UserController.java)  
 ├── model/         # Entidad JPA (User.java)  
 ├── repository/    # Interfaz de acceso a la BD (UserRepository.java)  
 ├── service/       # Lógica de negocio (UserService.java)  
 ├── exception/     # Manejo de errores (UserNotFoundException.java, GlobalExceptionHandler.java)  
 ├── Application.java  # Clase principal de Spring Boot  

---

## 🚀 Cómo ejecutar la API

### 1️⃣ Clonar el repositorio
git clone https://github.com/alvaro944/CRUD-Users-Springboot.git  
cd CRUD-Users-Springboot  

### 2️⃣ Configurar la base de datos

Por defecto, la API usa **H2 en modo persistente**. Para mantener los datos entre reinicios, revisa el archivo:  
📂 src/main/resources/application.properties  

spring.datasource.url=jdbc:h2:file:./data/usersdb  
spring.datasource.driverClassName=org.h2.Driver  
spring.datasource.username=sa  
spring.datasource.password=  
spring.jpa.hibernate.ddl-auto=update  
spring.h2.console.enabled=true  
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect  

✅ **Si prefieres MySQL**, cambia la configuración a:  

spring.datasource.url=jdbc:mysql://localhost:3306/usersdb  
spring.datasource.username=root  
spring.datasource.password=tu_contraseña  
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect  

🔹 **Crea la base de datos en MySQL antes de ejecutar el proyecto**:  

CREATE DATABASE usersdb;  

---

### 3️⃣ Ejecutar la aplicación

📌 Desde IntelliJ IDEA:  
Ejecuta la clase `Application.java` (o `DemoApplication.java` si no la has renombrado).  

📌 Desde la terminal con Maven:  
mvn spring-boot:run  

📌 Desde la terminal con Gradle:  
./gradlew bootRun  

Si todo está bien, verás en la consola:  

Tomcat started on port(s): 8080 (http) with context path ''  
Started UserApplication in X seconds  

✅ **La API ahora está corriendo en** http://localhost:8080/  

---

## 📝 Documentación de la API

Método | Endpoint | Descripción  
------------|------------|----------------  
GET | /users | Obtener todos los usuarios.  
GET | /users/{id} | Obtener un usuario por ID.  
POST | /users | Crear un nuevo usuario.  
PUT | /users/{id} | Actualizar un usuario por ID.  
DELETE | /users/{id} | Eliminar un usuario por ID.  

---

## 🧪 Pruebas con Postman

📌 **Ejemplo para `POST /users`**  
Selecciona `POST` y usa esta URL en **Postman**:  
http://localhost:8080/users  

En el **body** (selecciona `raw` y `JSON` en Postman):  

{  
    "name": "Juan Pérez",  
    "email": "juanperez@email.com",  
    "age": 30  
}  

🔹 **Respuestas esperadas:**  
- 201 Created → Usuario creado.  
- 400 Bad Request → Error en los datos enviados.  

---

## 🚀 Acceder a la base de datos con H2

Si usas H2, puedes ver los datos en la consola de H2 en el navegador:  
http://localhost:8080/h2-console  

📌 **Configuración para acceder:**  
- **JDBC URL:** jdbc:h2:file:./data/usersdb  
- **User:** sa  
- **Password:** *(dejar vacío)*  

---

## ❌ Manejo de errores

La API maneja los errores con `@ExceptionHandler`.  
Ejemplo de respuestas en caso de error:

🔴 **Si el usuario no existe (`GET /users/100`)**:  

{  
    "error": "Usuario no encontrado"  
}  

🔴 **Si intentas registrar un email ya existente (`POST /users`)**:  

{  
    "error": "El email ya está registrado."  
}  

---

## 🛠 Tecnologías Usadas

✅ **Java 21**  
✅ **Spring Boot 3.2.2**  
✅ **Spring Data JPA**  
✅ **H2 / MySQL**  
✅ **Maven**  
✅ **Postman para pruebas**  

---

## 📌 Cómo contribuir

Si quieres mejorar este proyecto, sigue estos pasos:

1️⃣ **Haz un fork del repositorio.**  
2️⃣ **Crea una nueva rama para tu feature:**  
git checkout -b mi-nueva-feature  

3️⃣ **Realiza cambios y haz commit:**  
git commit -m "Añadida nueva funcionalidad"  

4️⃣ **Sube tu rama:**  
git push origin mi-nueva-feature  

5️⃣ **Crea un Pull Request en GitHub.**  

---

## 📌 Autor

Desarrollado por **Alvaro** 🚀  
Si tienes dudas o sugerencias, ¡no dudes en contribuir! 😃  
