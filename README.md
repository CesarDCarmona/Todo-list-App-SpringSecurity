
# Todo-list-app

Aplicacion TODO. Una aplicación TODO permite llevar un control de tareas, añadiendo,  actualizando y eliminando tareas o actividad.

La aplicación consta de 2 Api Rest encargadas de la gestión de tareas y usuario, asi como una pequeña interfaz web que permite la autenticación para accesar y mostrar las acciones de tareas.

## Tecnologias aplicadas
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)




## Author

- [@CesarDCarmona](https://www.github.com/CesarDCarmona)


## Configuración de Aplicación

Configuración de Todo-list-app.

  ### Requerimientos:

    Java 17
    IDE que soporte Spring (Visual Studio Code)
    MySql
    Insomnia o postman (Opcional).

## Pasos de Configuración

1-. Descargar o Clonar Codigo


GitHubCLI
```
  gh repo clone CesarDCarmona/todo-list-app
```
o
Ingresar a 
https://github.com/CesarDCarmona/todo-list-app.git y descargar.
 
2-. Generar Base de datos
```sql
  create database nombrebase
```
No se incluye script sql, ya que la aplicación se encargará de la cración de las tablas, con la siguiente linea del properties.

```
spring.jpa.hibernate.ddl-auto=update
```


3-. Cargar tu Codigo en tu IDE preferido, y editar application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/basededatos
spring.datasource.username= tuusuario
spring.datasource.password= tupassword
```
4-. Compilar y correr el proyecto 

<image src="src/main/resources/images/TodoApp.png" alt="Descripción de la imagen">

En caso de tener ocupado el puerto puedes cambiarlo en la siguiente linea del application.properties

```
server.port = 
```


## Demo

Una vez ejecutando el proecto ingresar a la url:
```
http://localhost:{puerto}
```

<image src="src/main/resources/images/Sesion.png" alt="Descripción de la imagen">

## Nota:
Para ingresar a la aplicación es necesario insertar un usuario en la tabla Users generada en tu Base de datos. 

También puedes hacer uso de la Api user para registrar un usuario.

```sql
  http://localhost:8080/api/v1/user/addUser
```
## API User Reference

#### Post add user

```http
  POST /addUser
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `string` | **Requerido**. Tu nombre de usuario |
| `password` | `string` | **Requerido**. Tu contraseña de usuario |

#### Alta desde Insomnia


<image src="src/main/resources/images/PostUser.png" alt="Descripción de la imagen">

### Si lo prefieres puedes usar Swagger

Ingresando a la documentación de las API
```http
http://localhost:8080/api/documentacion/ui.html
```
<image src="src/main/resources/images/AddUserSwagger.png" alt="Descripción de la imagen">


## Screenshots de Aplicación en Funcion 

<image src="src/main/resources/images/Sesion.png" alt="Descripción de la imagen">
<image src="src/main/resources/images/CreaTarea.png" alt="Descripción de la imagen">
<image src="src/main/resources/images/ListaTareas.png" alt="Descripción de la imagen">


## Soporte

Para soporte, enviar email cicinhocarmona06@gmail.com
