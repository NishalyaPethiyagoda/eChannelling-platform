package com.Doctor.DoctorService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Data
@Entity
public class DoctorModel {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scheduleId;
    private String doctorId;
    private String location;
    private String address;
    private LocalDate practiceDate;
    private LocalTime practiceTime;
    
    public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getPracticeDate() {
		return practiceDate;
	}

	public void setPracticeDate(LocalDate practiceDate) {
		this.practiceDate = practiceDate;
	}

	public LocalTime getPracticeTime() {
		return practiceTime;
	}

	public void setPracticeTime(LocalTime practiceTime) {
		this.practiceTime = practiceTime;
	}

	public void setId(Integer id) {
        // TODO Auto-generated method stub
		this.scheduleId = id;
        // throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

}