import http from "./axios/http-common";

class CountryService {
  getCountries() {
    return http.get("/countries");
  }
}

const service = new CountryService() 

export default service;