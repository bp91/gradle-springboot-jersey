package it.testWebapp.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	public Timestamp creationtime;
	public String name;
	public String surname;
	public String email;
	
	public Timestamp getCreationtime() {
		return this.creationtime;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
