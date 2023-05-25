package com.project.muzo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;
	private String phone;
	private String mail;
	private String status;
	private String description;
	private String date;


	public Appointment() {
	}

	public Appointment(String firstName, String lastName, String mail, String phone, String status, String description,
			String date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.status = status;
		this.description = description;
		this.date = date;

	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMail() {
		return mail;
	}

	public String getPhone() {
		return phone;
	}

	public String getStatus() {
		return status;
	}

	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDate(String date) {
		this.date = date;
	}

}