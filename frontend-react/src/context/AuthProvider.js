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
