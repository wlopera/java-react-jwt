import axios from "axios";
// import {
//   SESSION_EXPIRED,
//   UNAUTHORIZED,
//   UNATHORIZED_MESSAGE,
//   USER_NOT_FOUND,
//   USER_NOT_FOUND_MESSAGE,
// } from "../../constants";

const { BACKEND_URL } = window["runConfig"];

const instance = axios.create({
  baseURL: BACKEND_URL,
  headers: {
    "Content-type": "application/json",
  },
});

// Add a request interceptor
instance.interceptors.request.use(function (config) {
  const token = localStorage.getItem("token");
  //console.log("LocalStorage-token", token);
  if (token) {
    config.headers.Authorization = token;
  }

  return config;
});

export default instance;