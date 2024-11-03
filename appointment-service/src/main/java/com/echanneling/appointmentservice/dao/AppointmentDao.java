package com.echanneling.appointmentservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.echanneling.appointmentservice.model.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Integer> {
	@Query("SELECT COALESCE(MAX(a.appointmentNumber), 0) FROM Appointment a WHERE a.scheduleId = ?1")
	int findMaxAppointmentNumberByScheduleId(Integer scheduleId);
	
	List<Appointment> findByPatientId(Integer patientId);
}