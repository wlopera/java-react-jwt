package com.wlopera.jwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.jwt.model.Country;

@RestController
public class CountryController {

	@GetMapping("/countries")
	public List<Country> getCountries() {
		return getCountriesList();
	}


	private List<Country> getCountriesList() {
		List<Country> countries = new ArrayList<>();
		
		countries.add(new Country("Argentina", "Buenos Aires", "Peso Argentino", "Español", "Sur America"));
		countries.add(new Country("Bélgica", "Bruselas", "Euro", "Neerlandés, Francés y Alemán", "Europa"));
		countries.add(new Country("China", "Pekín", "RMB", "Chino", "Asia"));
		countries.add(new Country("Panamá", "Ciudad de Panamá", "Balboa", "Español", "Centro America"));
		countries.add(new Country("Venezuela", "Caracas", "Bolívar", "Español", "Sur America"));
		countries.add(new Country("USA", "Washington", "Dolar Amerino", "Inglés", "Norte America"));
		
		return countries;
	}

}
