package com.project.muzo;


import java.util.Arrays;
import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import com.project.muzo.model.Admin;
import com.project.muzo.service.AdminService;
import com.project.muzo.model.Appointment;
import com.project.muzo.service.AppointmentService;


@SpringBootApplication
public class Main extends SpringBootServletInitializer {


	
	@Autowired
	AdminService myAdminService;

	@Autowired
	AppointmentService myAppointmentService;


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}

	@Bean(name = "database")
	public CommandLineRunner run() throws Exception {
		return (args) -> {


			System.out.println("Deleting appointment table...\n");
			myAppointmentService.deleteAllAppointments();
	
		
			System.out.println("Adding Admon...\n");
			Admin admin = new Admin("liliana@gmail.com", "123");

			myAdminService.addUser(admin);


			
		};
	}

	@Bean
	@DependsOn({ "database" })
	ServletRegistrationBean jsfServletRegistration(ServletContext servletContext) {
		// spring boot only works if this is set
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		// registration
		ServletRegistrationBean srb = new ServletRegistrationBean();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	}
}
