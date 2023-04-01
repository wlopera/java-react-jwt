import { useContext, useEffect } from "react";
import { useNavigate  } from "react-router-dom";
import { AuthContext } from "../../context/AuthProvider";

const Logout = () => {

  const { setAuth } = useContext(AuthContext);

  const navigate = useNavigate();

  useEffect(() => {
    setAuth(false);
    sessionStorage.removeItem("token");
    navigate("/login");
  }, [setAuth, navigate]);

  return null;
};

export default Logout;
