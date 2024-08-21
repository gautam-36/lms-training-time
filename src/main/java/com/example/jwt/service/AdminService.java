package com.example.jwt.service;

import com.example.jwt.dtos.AdminResponseDto;
import com.example.jwt.entity.Admin;
import com.example.jwt.entity.User;
import com.example.jwt.repository.AdminRepository;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AdminRepository adminRepository;
    public AdminResponseDto createAdmin(Integer user_id){

        Optional<User> optionalUser = userRepository.findById(user_id);
        User user =  new User();
        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        Admin admin =  new Admin();
        admin.setEmail(user.getEmail());
        admin.setName(user.getName());
        admin.setUser(admin.getUser());

        AdminResponseDto adminResponseDto = new AdminResponseDto();

        adminResponseDto.setName(admin.getName());
        adminResponseDto.setEmail(admin.getEmail());
        adminResponseDto.setUser(admin.getUser());
        return adminResponseDto;
    }

    public List<Admin> getAllAdmins(){
        return adminRepository.findAll();
    }
}
