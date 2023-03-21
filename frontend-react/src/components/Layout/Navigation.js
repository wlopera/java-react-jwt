import React from "react";
import { NavLink } from "react-router-dom";

import classes from "./Navigation.module.css";

const Navigation = () => {
  const token = sessionStorage.getItem("token");
  console.log(111111111111111, token)

  return (
    <nav
      className="navbar navbar-expand-lg navbar-light bg-custom-secondary"
      style={{ color: "white" }}
    >
      <div className="container-fluid">
        <h1>Java - React JWT</h1>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>

        <div className="collapse navbar-collapse" id="navbarNav">
          <nav className={classes.nav}>
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {!token && (
              <li className="nav-item">
                <NavLink
                  to="/login"                  
                  className={(navData) => (navData.isActive ? classes.active : "nav-link")}
                >
                  Conectarse
                </NavLink>
              </li>
              )}
              {token && (
                <li className="nav-item">
                  <NavLink
                    to="/countries"
                    className={(navData) => (navData.isActive ? classes.active : "nav-link")}
                  >
                    Países
                  </NavLink>
                </li>
              )}
              {token && (
                <li className="nav-item">
                  <NavLink
                    to="/logout"
                    className={(navData) => (navData.isActive ? classes.active : "nav-link")}
                  >
                    Salir
                  </NavLink>
                </li>
              )}
            </ul>
          </nav>
        </div>
      </div>
    </nav>
  );
};

export default Navigation;
