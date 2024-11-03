package com.eChannelling.eChannelling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eChannelling.eChannelling.repository.LabReportRequestRepository;

// import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.eChannelling.eChannelling.entity.LabReportRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lab_reports")
public class LabReportRequestController {
    @Autowired
    private LabReportRequestRepository LabReport;

    @PostMapping("/request_to_lab")
    public String request_to_lab(@RequestBody LabReportRequest item) {
        LabReport.save(item);
        return "Item added successfully";
    }

    @GetMapping("/get_all_requests")
    public List<LabReportRequest> get_all_requests() {
        return LabReport.findAll();
    }

    @GetMapping("/get_request_by_status/{status}")
    public List<LabReportRequest> get_request_by_status(@PathVariable int status) {
        return LabReport.findByStatus(status);
    }

    @GetMapping("/search")
    public List<LabReportRequest> getUsersByStatusAndDoctorIdAndPatientId(
            @RequestParam(required = true) int status,
            @RequestParam(required = true) String doctorId,
            @RequestParam(required = true) String patientId) {
        return LabReport.findByStatusAndDoctorIdAndPatientId(status, doctorId, patientId);
    }

    @PutMapping("updateUserStatus/{id}/{status}")
        public ResponseEntity<String> updateUserStatus(@PathVariable int id, @PathVariable int status) {
        Optional<LabReportRequest> optionalRequest = LabReport.findById((long) id);
        if (optionalRequest.isPresent()) {
            LabReportRequest request = optionalRequest.get();
            request.setStatus(status);
            LabReport.save(request);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }



}
