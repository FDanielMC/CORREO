package com.project.muzo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.muzo.model.Admin;
import com.project.muzo.repository.AdminRepository;


@Service
public class AdminService {

	private final AdminRepository adminRepository;

	@Autowired
	public AdminService(AdminRepository AdminRepository) {
		this.adminRepository = AdminRepository;
	}

	public Admin addUser(Admin admin) {
		if (!adminRepository.existsByMail(admin.getMail())) {
			return adminRepository.save(admin);
		}
		return null;

	}


	public Admin getUserByEmail(String mail) {
		return adminRepository.findByMail(mail);

	}


}