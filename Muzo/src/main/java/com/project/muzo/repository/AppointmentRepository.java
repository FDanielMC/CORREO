package com.project.muzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.muzo.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Appointment findByMail(String mail);
    boolean existsByMail(String mail);
    void deleteByMail(String mail);
}
