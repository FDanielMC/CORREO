package com.project.muzo.beans;


import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import com.project.muzo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.project.muzo.model.Admin;


@ManagedBean
@Component
@ApplicationScoped
public class LoginBean {
	Admin admin;
	
    @Autowired
    AdminService adminService;

    public boolean login(String username, String password) {
        // ¿Usuario en la BD?
        admin = adminService.getUserByEmail(username);
        // Entrada valida?
        if (admin != null  && admin.getPassword().equals(password)) {
            // Redirigimos al usuario al nuevo.xhtml
            return true;
        } else {        
            // Mantenemos al usuario en index.xhtml
            return false;
        }
    }

}
