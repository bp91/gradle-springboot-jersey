package it.testWebapp.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	public Integer id;
	@Column(name="creationtime", insertable = false, updatable = false, columnDefinition = " timestamp default now()")
	public Timestamp creationtime;
	@Column(name="name", nullable = false)
	public String name;
	@Column(name="surname", nullable = false)
	public String surname;
	@Column(name="email", nullable = false)
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
