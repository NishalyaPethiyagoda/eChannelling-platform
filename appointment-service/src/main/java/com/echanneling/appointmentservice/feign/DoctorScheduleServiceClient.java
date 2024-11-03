package com.echanneling.appointmentservice.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DoctorScheduleServiceClient {
	private final RestTemplate restTemplate;
    private final String doctorScheduleServiceUrl;

    @Autowired
    public DoctorScheduleServiceClient(RestTemplateBuilder restTemplateBuilder,
                                       @Value("${doctorScheduleService.url}") String doctorScheduleServiceUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.doctorScheduleServiceUrl = doctorScheduleServiceUrl;
    }

    public boolean isScheduleIdValid(Integer scheduleId) {
        try {
            ResponseEntity<Void> response = restTemplate.getForEntity(
                    doctorScheduleServiceUrl + "/doctor/DocById" + scheduleId, Void.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }
}