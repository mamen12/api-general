package com.micro.general.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
	
	@JsonProperty(value = "id")
	private String idUser;
	
	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "email")
	private String email;

	@JsonProperty(value = "active")
	private Integer isActive;

	
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
