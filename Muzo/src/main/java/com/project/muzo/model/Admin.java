package com.project.muzo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	private String password;
	private String mail;
	


	public Admin() {
	}

	public Admin(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}


	public Long getUserId() {
		return userId;
	}


	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
