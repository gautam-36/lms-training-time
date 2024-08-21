package com.example.jwt.service;

import com.example.jwt.dtos.TeacherResponseDto;
import com.example.jwt.entity.Teacher;
import com.example.jwt.entity.User;
import com.example.jwt.repository.TeacherRepository;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;

    public TeacherResponseDto createTeacher(Integer user_id){

        Optional<User> optionalUser =  userRepository.findById(user_id);
        User user =  new User();
        if(optionalUser.isPresent()){
            user =  optionalUser.get();
        }

        Teacher teacher = new Teacher();
        teacher.setEmail(user.getEmail());
        teacher.setName(user.getName());
        teacher.setUser(user);

         TeacherResponseDto teacherResponseDto =  new TeacherResponseDto();
         teacherResponseDto.setEmail(teacher.getEmail());
         teacherResponseDto.setName(teacher.getName());
         teacherResponseDto.setUser(teacher.getUser());
         return teacherResponseDto;
    }


    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
