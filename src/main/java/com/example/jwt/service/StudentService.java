package com.example.jwt.service;

import com.example.jwt.dtos.StudentRequestDto;
import com.example.jwt.dtos.StudentResponseDto;
import com.example.jwt.entity.Student;
import com.example.jwt.entity.User;
import com.example.jwt.repository.StudentRepository;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserRepository userRepository;

    public StudentResponseDto createStudent(Integer userId) {
        Student student = new Student();
        User user = new User();
        // Fetching the user from the userRepo
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        student.setName(user.getName());
        student.setEmail(user.getEmail());
        // Saving user into student
        student.setUser(user);
        studentRepository.save(student);
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setUser(user);
        studentResponseDto.setId(student.getId());
        return studentResponseDto;
    }

    // get all students
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }


    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    public String deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return "Student with id " + id + " deleted successfully";
    }
}
