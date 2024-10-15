package com.example.attendease.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "classrooms")
public class Classroom {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String classCode; // unique class code for joining
	    private String className;
	    @JsonIgnore
	    private String studentsName;

	    @OneToMany(mappedBy = "classroom")
	    @JsonIgnore
	    private List<Student> students;

	    @OneToMany(mappedBy = "classroom")
	    @JsonIgnore
	    private List<Attendance> attendanceRecords;
	    
	    

		public Classroom() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getClassCode() {
			return classCode;
		}

		public void setClassCode(String classCode) {
			this.classCode = classCode;
		}

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}

		public List<Student> getStudents() {
			return students;
		}

		public void setStudents(List<Student> students) {
			this.students = students;
		}

		public List<Attendance> getAttendanceRecords() {
			return attendanceRecords;
		}

		public void setAttendanceRecords(List<Attendance> attendanceRecords) {
			this.attendanceRecords = attendanceRecords;
		}

		public String getStudentsName() {
			return studentsName;
		}

		public void setStudentsName(String studentsName) {
			this.studentsName = studentsName;
		}
		
	    
	    
}