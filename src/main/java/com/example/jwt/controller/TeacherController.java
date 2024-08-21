package com.example.jwt.controller;

import com.example.jwt.dtos.TeacherResponseDto;
import com.example.jwt.entity.Teacher;
import com.example.jwt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/create/{user_id}")
    public TeacherResponseDto createTeacher(@PathVariable Integer user_id){
        return teacherService.createTeacher(user_id);
    }


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }


}
