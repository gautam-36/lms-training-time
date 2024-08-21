package com.example.jwt.controller;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Authorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.jwt.entity.User;
import com.example.jwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    Logger log = LoggerFactory.getLogger(UserService.class);
//    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User currentUser = (User) authentication.getPrincipal();
            return ResponseEntity.ok(currentUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    //@PreAuthorize()
    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
      // log.info("Hitted ");
        List<User> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }

   @GetMapping("/{user_id}")
    public User getUserById (@PathVariable Integer user_id){
        return userService.getUserById(user_id);
   }
}

