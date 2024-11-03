package com.echanneling.appointmentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.echanneling.appointmentservice.dao.AppointmentDao;
import com.echanneling.appointmentservice.feign.DoctorScheduleServiceClient;
import com.echanneling.appointmentservice.model.Appointment;

@Service
public class AppointmentService {
	
	@Autowired
    AppointmentDao appointmentDao;
	
	
	DoctorScheduleServiceClient doctorScheduleServiceClient;
	
	@Autowired
    public AppointmentService(DoctorScheduleServiceClient doctorScheduleServiceClient) {
        this.doctorScheduleServiceClient = doctorScheduleServiceClient;
    }

	public ResponseEntity<List<Appointment>> getAllAppointments() {
		try {
            return new ResponseEntity<>(appointmentDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addAppointment(Appointment appointment) {
        try {
        	/*if (!doctorScheduleServiceClient.isScheduleIdValid(appointment.getScheduleId())) {
                throw new IllegalArgumentException("Invalid scheduleId: " + appointment.getScheduleId());
            }*/
        	int maxAppointmentNumber = appointmentDao.findMaxAppointmentNumberByScheduleId(appointment.getScheduleId());
            appointment.setAppointmentNumber(maxAppointmentNumber + 1);
            appointmentDao.save(appointment);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(Integer patientId) {
        try {
            return new ResponseEntity<>(appointmentDao.findByPatientId(patientId),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    } 

}