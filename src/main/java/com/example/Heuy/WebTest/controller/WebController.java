package com.example.Heuy.WebTest.controller;

import com.example.Heuy.WebTest.entites.Student;
import com.example.Heuy.WebTest.services.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("store/v1")
public class WebController {

    @Autowired
    WebService webService;

    @PostMapping("createStudent")
    public String createStudent(@RequestBody Student student){
        webService.createStudent(student);
        return student.getName();
    }

    @GetMapping("getstudentbyname/{id}")
    public Optional<Student> getStudent(@PathVariable int id){
        return webService.getStudent(id);
    }

    @PostMapping("changelevel/{id}")
    public String changeLevel(@PathVariable int id){
        return webService.changeLevel(id);
    }

}
