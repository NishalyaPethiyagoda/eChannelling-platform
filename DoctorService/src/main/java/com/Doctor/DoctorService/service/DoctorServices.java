package com.Doctor.DoctorService.service;

import com.Doctor.DoctorService.dao.DoctorDao;
// import com.Doctor.DoctorService.model.AppointmentSummaryModel;
import com.Doctor.DoctorService.model.DoctorModel;
// import com.Doctor.DoctorService.model.LabReportModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.util.UriComponentsBuilder;
// import org.springframework.format.annotation.DateTimeFormat;
// import java.util.Map;
// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServices {

    @Autowired
    DoctorDao doctordao;

    public ResponseEntity<List<DoctorModel>> getAllSchedules(){
        try{
            return new ResponseEntity<>(doctordao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    public ResponseEntity<String> addSchedule(DoctorModel doctormodel) {
        doctordao.save(doctormodel);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public DoctorModel getScheduleById(Integer id) {
        return doctordao.findById(id).orElse(null);
    }

    public ResponseEntity<List<DoctorModel>> getSchedulesByLocation(String location) {
        try {
            return new ResponseEntity<>(doctordao.findByLocation(location),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<DoctorModel>> getSchedulesByDoctorId(String doctorId) {
        try {
            return new ResponseEntity<>(doctordao.findByDoctorId(doctorId),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    } 

    public ResponseEntity<String> updateSchedule(Integer id, DoctorModel doctormodel) {
        if (doctordao.existsById(id)) {
            doctormodel.setId(id);
            doctordao.save(doctormodel);
            return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedule not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteSchedule(Integer id) {
        if (doctordao.existsById(id)) {
            doctordao.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Schedule not found", HttpStatus.NOT_FOUND);
        }
    }


    /*public ResponseEntity<Map<String, Object>> getAppointmentsSummaryForToday(Integer doctorId) {
        try {
            // Assuming there's an endpoint in the appointment service to get today's appointments
            String url = UriComponentsBuilder.fromHttpUrl(APPOINTMENT_SERVICE_URL)
                .queryParam("doctorId", doctorId)
                .queryParam("date", LocalDate.now().toString())
                .toUriString();
            
            // Replace AppointmentSummaryModel with the appropriate model class
            AppointmentSummaryModel[] appointments = restTemplate.getForObject(url, AppointmentSummaryModel[].class);
            
            // Count the number of appointments
            int appointmentCount = appointments != null ? appointments.length : 0;

            // Prepare the response
            Map<String, Object> response = Map.of(
                "location", appointments.length > 0 ? appointments[0].getLocation() : "No location", 
                "appointmentCount", appointmentCount
            );
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<List<LabReportModel>> getLabReportsByDoctorAndPatientId(Integer doctorId, Integer patientId) {
    try {
        String url = UriComponentsBuilder.fromHttpUrl(LAB_REPORT_SERVICE_URL)
            .queryParam("doctorId", doctorId)
            .queryParam("patientId", patientId)
            .toUriString();

        LabReportModel[] reports = restTemplate.getForObject(url, LabReportModel[].class);

        return new ResponseEntity<>(List.of(reports), HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
	}*/

}