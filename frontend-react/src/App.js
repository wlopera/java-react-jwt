import React from "react";
import { Route, Routes } from "react-router-dom";

import Home from "./components/Form/Home";
import Layout from "./components/Layout/Layout";
import Login from "./components/Form/Login";
import Logout from "./components/Form/Logout";
import Country from "./components/Form/Country";

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/countries" element={<Country />} />
        <Route path="/logout" element={<Logout />} />
      </Routes>
    </Layout>
  );
}

export default App;
