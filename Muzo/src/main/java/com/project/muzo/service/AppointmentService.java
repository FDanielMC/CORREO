package com.project.muzo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.muzo.model.Appointment;
import com.project.muzo.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;

	@Autowired
	public AppointmentService(AppointmentRepository AppointmentRepository) {
		this.appointmentRepository = AppointmentRepository;
	}

	public Appointment addAppointment(Appointment appointment) {
			return appointmentRepository.save(appointment);
	}

	public Appointment getAppointment(Long appointmentId) {
		return appointmentRepository.findById(appointmentId).get();
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	public Appointment updateAppointment(Appointment appointment) {
		if (appointmentRepository.existsById(appointment.getAppointmentId())) {
			return appointmentRepository.save(appointment);
		}

		return null;
	}

	public void deleteAppointment(Long appointmentId) {
		appointmentRepository.deleteById(appointmentId);
	}

	public void deleteAllAppointments() {
		appointmentRepository.deleteAll();
		;
	}

	public Appointment getAppointmentByEmail(String mail) {
		return appointmentRepository.findByMail(mail);

	}

	public boolean appointmentExist(String mail){
		return appointmentRepository.existsByMail(mail);
	}
}