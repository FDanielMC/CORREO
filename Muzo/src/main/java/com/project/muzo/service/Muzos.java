package com.project.muzo.service;



import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.project.muzo.beans.LoginBean;



@ManagedBean
@Component
@ApplicationScope
public class Muzos {


	
	@Autowired
	LoginBean loginBean;


	public Muzos() {

	}

	public String login(String username, String password) {
		if (loginBean.login(username, password)) {
			return "table.xhtml?faces-redirect=true";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario o contraseña es erroneo",
					"No se");
			context.addMessage("somekey", msg);
			return null;
		}
	}








	
	
}
