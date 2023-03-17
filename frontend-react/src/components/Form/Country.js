import React, { useEffect, useState } from "react";

import service from "../../service/country_service";

const Country = () => {
  const [countries, setCountries] = useState(null);

  useEffect(() => {

    const loadData = async () => {
      const res = await service.getCountries();
      if (res.data.error) {
        alert(res.data.error.message);
      } else {
        console.log("##=> Paises:", res.data)
        setCountries(res.data);
      }
    }
    loadData();

  }, [])
  

console.log(12345, countries);

  return (
    <div>
      <h1>Ventana de Jugadores</h1>
      <hr />
    </div>
  );
};

export default Country;
