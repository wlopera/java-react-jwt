import { useEffect } from "react";
import { useNavigate  } from "react-router-dom";

const Logout = () => {
  const navigate = useNavigate();
  useEffect(() => {
    sessionStorage.removeItem("token");
    navigate("/");
    window.location.reload();
  }, []);

  return null;
};

export default Logout;
