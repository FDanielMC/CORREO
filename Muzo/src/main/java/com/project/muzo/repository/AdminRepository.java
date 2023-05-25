package com.project.muzo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.muzo.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByMail(String mail);
    boolean existsByMail(String mail);
}
