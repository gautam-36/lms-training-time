package com.example.jwt.controller;
import com.example.jwt.dtos.AdminResponseDto;
import com.example.jwt.entity.Admin;
import com.example.jwt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;


    @PostMapping("/create/{user_id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AdminResponseDto createAdmin(@PathVariable Integer user_id){
        return adminService.createAdmin(user_id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

}
