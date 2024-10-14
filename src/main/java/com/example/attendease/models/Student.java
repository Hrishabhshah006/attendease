package com.example.attendease.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "students")
public class Student {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	 	@Column(unique = true)
	 	private String studentID;
	 	
	    private String username;
	    private String password;
	    private String email;
	    
	    private String classCode; // unique class code for joining
//	    private String className;
	    
	    @OneToMany(mappedBy = "student")
	    private Set<Attendance> attendances;
	    
	    @ManyToOne
	    @JoinColumn(name = "classroom_id", nullable = false)
	    private Classroom classroom;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Classroom getClassroom() {
			return classroom;
		}

		public void setClassroom(Classroom classroom) {
			this.classroom = classroom;
		}

		public Student() {
			super();
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getStudentID() {
			return studentID;
		}

		public void setStudentID(String studentID) {
			this.studentID = studentID;
		}

		public String getClassCode() {
			return classCode;
		}

		public void setClassCode(String classCode) {
			this.classCode = classCode;
		}

		public Set<Attendance> getAttendances() {
			return attendances;
		}

		public void setAttendances(Set<Attendance> attendances) {
			this.attendances = attendances;
		}

//		public String getClassName() {
//			return className;
//		}
//
//		public void setClassName(String className) {
//			this.className = className;
//		}
		
	    
	    
	    
}