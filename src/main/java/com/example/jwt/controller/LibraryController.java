package com.example.jwt.controller;

import com.example.jwt.dtos.LibraryRequestDto;
import com.example.jwt.entity.Library;
import com.example.jwt.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;

    @PostMapping("/add")
    public Library addLibrary(@RequestBody LibraryRequestDto library){
        return libraryService.addLibrary(library);
    }

    @GetMapping("/")
    public List<Library> getAllLibrary(){
        return libraryService.getAllLibrary();
    }

    @GetMapping("/{id}")
    public Library findById(Integer id){
        return libraryService.findById(id);
    }

}
