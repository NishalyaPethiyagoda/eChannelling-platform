package com.eChannelling.eChannelling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eChannelling.eChannelling.entity.LabReportPDF;

public interface LabReportPDFRepository extends JpaRepository<LabReportPDF, Long>{

    Optional<LabReportPDF> findByReportId(int reportId);
    
}
