import http from "./axios/http-common";

class AuthService {
  login(data) {
    return http.post("/login", data);
  }
}

export default new AuthService();