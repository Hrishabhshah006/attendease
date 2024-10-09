package com.example.attendease.dto;

import java.time.LocalDate;

public class AttendanceData {

	private Long studentId;
    private boolean isPresent;
    private LocalDate date; 
    
    public AttendanceData() {}
    
	public AttendanceData(Long studentId, boolean isPresent, LocalDate date) {
		super();
		this.studentId = studentId;
		this.isPresent = isPresent;
		this.date = date;
	}

	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public boolean isPresent() {
		return isPresent;
	}
	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
    
    
}
