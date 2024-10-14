package com.example.attendease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendease.models.Admin;
import com.example.attendease.models.Classroom;
import com.example.attendease.models.Student;
import com.example.attendease.repository.ClassroomRepository;
import com.example.attendease.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private ClassroomRepository classroomRepository;

    
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public String login(String studentID, String password) {

        Student student = studentRepository.findByStudentID(studentID);

        if (student!= null && student.getStudentID().equals(studentID) && student.getPassword().equals(password)) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public List<Student> getStudentsInClassroom(Long classroomId) {
        return studentRepository.findByClassroomId(classroomId);
    }
    
    public String updateStudent(String classCode,String studentID, String userName) {
        // Find the student by ID
        Student existingStudent = studentRepository.findByStudentID(studentID);

        // Update the student details with the new values
        existingStudent.setClassCode(classCode);
        
        Classroom classroom = classroomRepository.findByClassCode(classCode).orElseThrow(() -> new RuntimeException("Invalid Class Code"));
        existingStudent.setClassroom(classroom);
        classroom.setStudentsName(userName);
        classroomRepository.save(classroom);
         studentRepository.save(existingStudent);

        return "Student updated successfully";
    }

    

}