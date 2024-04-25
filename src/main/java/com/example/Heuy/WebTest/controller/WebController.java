package com.example.Heuy.WebTest.controller;

import com.example.Heuy.WebTest.entites.Student;
import com.example.Heuy.WebTest.enums.Level;
import com.example.Heuy.WebTest.services.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("store/v1")
@RequiredArgsConstructor
public class WebController {


    private final WebService webService;

    @PostMapping("createStudent")
    public String createStudent(@RequestBody Student student){
        webService.createStudent(student);
        return student.getName();
    }

    @GetMapping("getstudentbyid/{id}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable int id){
        return webService.getStudent(id);
    }

    @GetMapping("getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return webService.getAllStudents();
    }

    @PutMapping("changelevel")
    public ResponseEntity<Level> changeLevel(@RequestParam("id") int id, @RequestParam("level") Level level){
        return webService.changeLevel(id, level);
    }

}
