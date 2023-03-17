package com.wlopera.jwt.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Country implements Serializable {
	private String name;
	private String capital;
	private String currency;
	private String language;
	private String location;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String name, String capital, String currency, String language, String location) {
		super();
		this.name = name;
		this.capital = capital;
		this.currency = currency;
		this.language = language;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Country [" + (name != null ? "name=" + name + ", " : "")
				+ (capital != null ? "capital=" + capital + ", " : "")
				+ (currency != null ? "currency=" + currency + ", " : "")
				+ (language != null ? "language=" + language + ", " : "")
				+ (location != null ? "location=" + location : "") + "]";
	}

}
