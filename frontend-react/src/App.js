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
