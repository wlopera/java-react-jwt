# java-react-jwt
Proyecto Java - React - Uso Token - Login - Logout - Data

Java:
  * JWT
  * Spring Boot
  * Security
  * Servicios Rest que permite:
    * Login: user/pass => Genera token
    * Consulta de Paises ==> Debe enviarse Token (filtro para validar token)

React:
  * APP básica de React
    * Navegación
    * Estilos css
    * Login
    * Consultar Países
    * Logout
  
## Salida: 

### Conectarse user/password (encriptado con md5)

![Captura](https://user-images.githubusercontent.com/7141537/226058203-7e686753-833f-4741-8ce8-f588ab10dd47.PNG)

![Captura1](https://user-images.githubusercontent.com/7141537/226058204-49cf857b-74e5-43c9-8b90-b790d96b81b0.PNG)

### Guardar token en LocalStorage JS

![Captura2](https://user-images.githubusercontent.com/7141537/226058207-e47588b4-d3e0-4c96-a5af-394bf0bc6ac2.PNG)

### Consultar servicio de paises pasando token

![Captura3](https://user-images.githubusercontent.com/7141537/226058196-7b87b059-d06c-4c51-9762-e52a0a5a4fa3.PNG)

![Captura4](https://user-images.githubusercontent.com/7141537/226058198-afd42edc-259f-4be6-9ef3-3668e7b7ad46.PNG)

### Consultar servicio de paises sin pasar token
![Captura5](https://user-images.githubusercontent.com/7141537/226058201-13509a37-195b-410a-a9a0-be8d8537fa6a.PNG)

![Captura6](https://user-images.githubusercontent.com/7141537/226058202-5fa073c3-9a6d-47ef-88bb-edafb83fe9ca.PNG)

### Consultar Datos de paises

* Refactor del proceso de navegacion: react-router-dom@6.9.0
#### index.js
```
  ...
  root.render(
   <BrowserRouter>
    <App />
   </BrowserRouter>
 );
 ...
```
#### App.js
```
  ...
    <Layout>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/countries" element={<Country />} />
        <Route path="/logout" element={<Logout />} />
      </Routes>
    </Layout>
```

#### Uso de use useNavigate y window reload para redireccionar las llamadas y refrescar la vista
```
import { useNavigate  } from "react-router-dom";
 ...
   const navigate = useNavigate();
 ...
   navigate("/");
   window.location.reload();
 ...
```

![Captura](https://user-images.githubusercontent.com/7141537/226667912-8d47fe9c-c2d6-4dc2-b146-5de032549e40.PNG)
![Captura1](https://user-images.githubusercontent.com/7141537/226667907-bbfe3665-fb39-4ea8-b077-a98555c6001c.PNG)


## Control de usuarios a traves de md5

### JAVA

#### Se agregaron dependencias POM : H2 y JPA
```
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
```

#### /jwt-java/src/main/resources/data.sql
```
INSERT INTO user (id, name, password, token) VALUES (1, 'lmessi','b37dd1a64f1ce367f6cc4a86c1dab964', null);
INSERT INTO user (id, name, password,token) VALUES (2, 'cr7','c9178aa682eadb31aa6d77e85c8cd9c6', null);
INSERT INTO user (id, name, password, token) VALUES (3, 'njunior','947995bffb3dee7aa54c607c84c6ff96', null);
INSERT INTO user (id, name, password, token) VALUES (4, 'wlopera','827ccb0eea8a706c4c34a16891f84e7b',null);
```

#### /jwt-java/src/main/resources/application.yaml
```
spring:
  datasource:
    url: jdbc:h2:mem:mydb
    username: sa
    password: 
    driverClassName: org.h2.Driver
    
  jpa:
    show-sql: true
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    
  h2:
    console:
      enabled: true
      path: /h2    
```
#### /jwt-java/src/main/java/com/wlopera/jwt/model/Response.java
```
package com.wlopera.jwt.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class Response implements Serializable {
	
	private Boolean success;
	private HttpStatus code;
	private String message;
	private String traceId;
	private String error;
	private Data data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [" + (success != null ? "success=" + success + ", " : "")
				+ (code != null ? "code=" + code + ", " : "") + (message != null ? "message=" + message + ", " : "")
				+ (traceId != null ? "traceId=" + traceId + ", " : "") + (error != null ? "error=" + error + ", " : "")
				+ (data != null ? "data=" + data : "") + "]";
	}
}

```
#### Actualizar controlador: /jwt-java/src/main/java/com/wlopera/jwt/controller/AuthController.java
```
...
@Autowired
	UserRepository repository;

	@PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody Login login) {

		SimpleDateFormat format = new SimpleDateFormat("DD/mm/YYYY HH:mm:ss");
		String date = format.format(new Date());

		System.out.println("Usuario: " + login);

		User userDB = repository.findByName(login.getUsername());
		System.out.println("Usuario DB: " + userDB);

		if (login.getPassword().equals(userDB.getPassword())) {
			String token = getJWTToken(login.getUsername(), date);

			Data data = new Data();
			data.setId(userDB.getId());
			data.setName(userDB.getName());
			data.setToken(token);

			Response response = Utility.getResponse(data);

			System.out.println("Response: " + response);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}
...
```

### REACT

#### src\context\AuthProvider.js
```
import { createContext, useState } from "react";

const AuthContext = createContext(undefined);

const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState(false);

  console.log("##==> Valor  autenticacion: ", auth);
  return (
    <AuthContext.Provider value={{ auth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
};

export { AuthProvider, AuthContext };

```

#### Actualizar
: index.js
```
root.render(
  <BrowserRouter>
    <AuthProvider>
      <App />
    </AuthProvider>
  </BrowserRouter>
);

```

### Se elimino el componente Layout y se genero NavigatePrivate y NavigatPublic para separar Header del login del home

#### Ejemplo de Logout.js para ver llamada a contexto y uso del navigate

```
import { useContext, useEffect } from "react";
import { useNavigate  } from "react-router-dom";
import { AuthContext } from "../../context/AuthProvider";

const Logout = () => {

  const { setAuth } = useContext(AuthContext);

  const navigate = useNavigate();

  useEffect(() => {
    setAuth(false);
    sessionStorage.removeItem("token");
    navigate("/login");
  }, [setAuth, navigate]);

  return null;
};

export default Logout;

```

#### Actualización de APP.js para mostrar control del login y logout y su Header

```
import React, { useContext } from "react";
import { Route, Routes } from "react-router-dom";

import Home from "./components/Form/Home";
import Login from "./components/Form/Login";
import Logout from "./components/Form/Logout";
import Country from "./components/Form/Country";
import { AuthContext } from "./context/AuthProvider";
import NavigationPrivate from "./components/Layout/NavigationPrivate";
import NavigationPublic from "./components/Layout/NavigationPublic";

function App() {
  const  {auth}  = useContext(AuthContext);

  console.log("##=> AUTH - APP", auth);

  return (
    <>
      {auth ? <NavigationPrivate /> : <NavigationPublic />}
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/countries" element={<Country />} />
        <Route path="/logout" element={<Logout />} />
      </Routes>
    </>
  );
}

export default App;
```

### Salidas:
![Captura](https://user-images.githubusercontent.com/7141537/229314044-a73aae78-f4f9-4b02-a8f4-90520bb42857.PNG)

![Captura1](https://user-images.githubusercontent.com/7141537/229314043-39d77eaa-0f31-4227-b6d2-ad2af8cbab7e.PNG)

