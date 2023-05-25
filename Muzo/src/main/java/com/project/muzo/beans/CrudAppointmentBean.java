package com.project.muzo.beans;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.muzo.model.Appointment;
import com.project.muzo.service.AppointmentService;
import com.project.muzo.service.EmailService;



@ManagedBean
@Component
@ApplicationScoped

/**
 * Clase que maneja operaciones CRUD (Create, Read, Update, Delete) para los usuarios en una base de datos.
 * Esta clase utiliza el patrón de diseño DAO (Data Access Object) para acceder a los datos de la base de datos
 */

public class CrudAppointmentBean {

    // TABLE.XHTML

    private List<Appointment> appointments;

    //NUEVO.XHTML

    private Appointment selectedAppointment;

	
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private EmailService emailService;

    // TABLE.XHTML
    @PostConstruct
    public void init() {
        this.appointments = appointmentService.getAllAppointments();

    }

    // TABLE.XHTML
    public void refresh() {
        this.appointments = appointmentService.getAllAppointments();
    }

     // TABLE.XHTML
    public List<Appointment> getAppointments() {
        return appointments;
    }


     // TABLE.XHTML
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    //NUEVO.XHTML
    public Appointment getSelectedAppointment() {
        return selectedAppointment;
    }

    //NUEVO.XHTML
    public void setSelectedAppointment(Appointment selectedAppointment) {
        this.selectedAppointment = selectedAppointment;
    }

    //NUEVO.XHTML
    public void openNew() {
        this.selectedAppointment = new Appointment(); 
    }

    //NUEVO.XHTML
    public void saveAppointment(String mail, String firstName, String date) {
        if (this.selectedAppointment.getAppointmentId() == null) {
            if(!appointmentService.appointmentExist(selectedAppointment.getMail())){
                appointmentService.addAppointment(selectedAppointment);
                refresh();
            }
        }
        
        String body = "Hola " + firstName + ".\n" + "Agendase tu cita para el: " + date; 
        emailService.sendEmail(mail, "Cita" + firstName , body);
    }     

   
   
}