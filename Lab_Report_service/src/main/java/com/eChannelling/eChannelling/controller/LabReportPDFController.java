package com.eChannelling.eChannelling.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eChannelling.eChannelling.entity.LabReportPDF;
import com.eChannelling.eChannelling.entity.LabReportRequest;
import com.eChannelling.eChannelling.repository.LabReportPDFRepository;


@RestController
@RequestMapping("/lab_reports/pdf")
public class LabReportPDFController {
    @Autowired
    private LabReportPDFRepository labReportPDFRepository;
    

    @PostMapping("/uploadPdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file,
            @RequestParam(required = true) int reportId) {
        
                LabReportPDF labReportPDF = new LabReportPDF();
                labReportPDF.setContentType(file.getContentType());
                labReportPDF.setFileName(file.getOriginalFilename());
                labReportPDF.setReportId(reportId);
                try {
                    labReportPDF.setFile(file.getBytes());
                    labReportPDFRepository.save(labReportPDF);
                    return new ResponseEntity<>("Upload Successful", HttpStatus.OK);
                } catch (IOException e) {
                    
                    e.printStackTrace();
                    return new ResponseEntity<>("Update fail", HttpStatus.BAD_REQUEST);
                }
        

    }

    @GetMapping("/getPdf/{id}")
    public ResponseEntity<LabReportPDF> getPdf(@PathVariable int id) {
        Optional<LabReportPDF> pdfDocument = labReportPDFRepository.findByReportId(id);
        if (pdfDocument.isPresent()) {
            LabReportPDF document = pdfDocument.get();
            return ResponseEntity.ok(document);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/get_all_reports")
    public List<LabReportPDF> get_all_reports() {
        return labReportPDFRepository.findAll();
    }
}
