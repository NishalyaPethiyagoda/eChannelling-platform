package com.Doctor.DoctorService.dao;

import com.Doctor.DoctorService.model.DoctorModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<DoctorModel, Integer> {
    List<DoctorModel> findByLocation(String location);
	List<DoctorModel> findByDoctorId(String doctorId);
}