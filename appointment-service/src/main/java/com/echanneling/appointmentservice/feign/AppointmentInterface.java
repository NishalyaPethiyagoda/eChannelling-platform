package com.echanneling.appointmentservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient("DOCTORSERVICE")
public interface AppointmentInterface {

	/*@GetMapping("doctor/{id}")
    public ResponseEntity<DoctorModel> getScheduleById(@PathVariable Integer id);*/
}
