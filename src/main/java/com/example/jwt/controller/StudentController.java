package com.example.jwt.controller;
import com.example.jwt.dtos.StudentResponseDto;
import com.example.jwt.entity.Student;
import com.example.jwt.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService =  studentService;
    }

    @PostMapping("/create/{user_id}")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public ResponseEntity<StudentResponseDto>  createStudent(@PathVariable Integer user_id){
        StudentResponseDto studentResponseDto;
        studentResponseDto =  studentService.createStudent(user_id);
        return  ResponseEntity.ok(studentResponseDto);
    }

    // getting all the students

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER')")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TEACHER')")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  String deleteUser(@PathVariable  Integer id){
        return studentService.deleteStudent(id);
    }
}
