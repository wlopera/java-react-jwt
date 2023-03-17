package com.wlopera.jwt.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {

	private String name;
	private String token;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [" + (name != null ? "name=" + name + ", " : "") + (token != null ? "token=" + token : "") + "]";
	}

}
