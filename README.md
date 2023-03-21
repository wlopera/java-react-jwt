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


