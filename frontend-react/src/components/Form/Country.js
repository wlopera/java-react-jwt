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
        console.log("##=> Paises:", res.data);
        setCountries(res.data);
      }
    };
    loadData();
  }, []);

  return (
    <div>
      {countries && (
        <table className="table table-striped">
          <thead>
            <tr>
              <th scope="col">País</th>
              <th scope="col">Capital</th>
              <th scope="col">Lenguaje</th>
              <th scope="col">Moneda</th>
              <th scope="col">Ubicación</th>
            </tr>
          </thead>
          <tbody>
            {countries.map((country) => (
              <tr key={country.name}>
                <td>{country.name}</td>
                <td>{country.capital}</td>
                <td>{country.language}</td>
                <td>{country.currency}</td>
                <td>{country.location}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default Country;
