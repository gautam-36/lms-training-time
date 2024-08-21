package com.example.jwt.controller;
import com.example.jwt.dtos.LoginReponse;
import com.example.jwt.dtos.LoginUserDto;
import com.example.jwt.dtos.RegisterUserDto;
import com.example.jwt.entity.User;
import com.example.jwt.service.AuthenticationService;
import com.example.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    @Autowired
    private  AuthenticationService authenticationService;
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService){
        this.jwtService = jwtService;

    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto){
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginReponse> authenticate(@RequestBody LoginUserDto loginUserDto ) {
        try{
            User authenticatedUser = authenticationService.authenticate(loginUserDto);
            String jwtToken = jwtService.generateToken(authenticatedUser);
            LoginReponse loginReponse = new LoginReponse();
            loginReponse.setToken(jwtToken);
            loginReponse.setExpiresIn(jwtService.getExpirationTime());
            return ResponseEntity.ok(loginReponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
            }
        }
    }
