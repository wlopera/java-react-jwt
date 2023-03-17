import http from "./axios/http-common";

class AuthService {
  login(data) {
    return http.post("/login", data);
  }
}

const service = new AuthService() 

export default service;