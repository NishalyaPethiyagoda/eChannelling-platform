package com.eChannelling.eChannelling.repository;
import com.eChannelling.eChannelling.entity.LabReportRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LabReportRequestRepository extends JpaRepository<LabReportRequest, Long>{
    List<LabReportRequest> findByStatus(int status);

    @Query("SELECT u FROM LabReportRequest u WHERE (u.status = :status) AND ( u.doctorId = :doctorId) AND (u.patientId = :patientId)")
    List<LabReportRequest> findByStatusAndDoctorIdAndPatientId(@Param("status") int status, @Param("doctorId") String doctorId, @Param("patientId") String patientId);
}
