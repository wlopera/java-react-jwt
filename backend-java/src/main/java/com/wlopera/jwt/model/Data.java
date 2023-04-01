package com.wlopera.jwt.model;

import java.io.Serializable;

/**
 * Respuesta del servicio
 * 
 * @author wlopera
 *
 */
public class Data implements Serializable {

	private static final long serialVersionUID = 2141823447059497785L;
	private Long id;
	private String name;
	private String token;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "Data [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (token != null ? "token=" + token : "") + "]";
	}
}
