package com.Doctor.DoctorService.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter

public class LabReportModel {
    private Integer reportId;
    private Integer doctorId;
    private Integer patientId;
    private String reportUrl;  // URL or path to the PDF file
    private LocalDate reportDate;
}
