package com.example.attendease.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendease.dto.AttendanceData;
import com.example.attendease.models.Attendance;
import com.example.attendease.models.Classroom;
import com.example.attendease.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	 @Autowired
	    private TeacherService teacherService;

//	     Teacher login - upon login, show the classrooms assigned to the teacher.
	   
	    @GetMapping("/{teacherId}/classrooms")
	    public List<Classroom> getClassrooms(@PathVariable Long teacherId) {
	        return teacherService.getClassroomsByTeacher(teacherId);
	    }


//	     Endpoint for the teacher to take attendance for a specific classroom.

	    @PostMapping("/{teacherId}/classroom/{classroomId}/attendance")
	    public List<Attendance> takeAttendance(@PathVariable Long teacherId,@PathVariable Long classroomId,@RequestBody List<AttendanceData> attendanceData) {
	        return teacherService.takeAttendance(teacherId, classroomId, attendanceData);
	    }
	    
	    
//	     Endpoint for the teacher to create a new classroom.
	    
	    @PostMapping("/{teacherId}/classrooms")
	    public Classroom createClassroom(@PathVariable Long teacherId, @RequestBody String classCode) {
	        return teacherService.createClassroom(teacherId, classCode);

}
}
