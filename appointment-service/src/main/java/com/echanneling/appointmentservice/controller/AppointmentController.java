package com.echanneling.appointmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echanneling.appointmentservice.model.Appointment;
import com.echanneling.appointmentservice.service.AppointmentService;

@RestController
@RequestMapping("appointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {
	
	@Autowired
    AppointmentService appointmentService;
    
    @Autowired
    Environment environment;
	
    @GetMapping("allAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }
    
    @PostMapping("add")
    public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment){
        return  appointmentService.addAppointment(appointment);
    }
    
    //get appointments by patient id
    @GetMapping("getpatientappointment/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable Integer patientId){
        return appointmentService.getAppointmentsByPatientId(patientId);
    }
}