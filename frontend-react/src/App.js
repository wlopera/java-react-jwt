import React from "react";
import { Route, Switch, Redirect } from "react-router-dom";

import Home from "./components/Form/Home";
import Layout from "./components/Layout/Layout";
import Login from "./components/Form/Login";
import Logout from "./components/Form/Logout";
import Country from "./components/Form/Country";

function App() {
  return (
    <Layout>
      <Switch>
        <Route path="/" exact>
          <Redirect to="home" />
        </Route>
        <Route path="/home">
          <Home />
        </Route>
        <Route path="/login">
          <Login />
        </Route>
        <Route path="/countries">
          <Country />
        </Route>
        <Route path="/logout">
          <Logout />
        </Route>
      </Switch>
    </Layout>
  );
}

export default App;
