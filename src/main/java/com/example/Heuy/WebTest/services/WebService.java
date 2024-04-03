package com.example.Heuy.WebTest.services;

import com.example.Heuy.WebTest.entites.Student;
import com.example.Heuy.WebTest.enums.Level;
import com.example.Heuy.WebTest.repo.WebTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebService {
    @Autowired
    WebTestRepository webTestRepository;

    //create a student
    public String createStudent(Student student){
        webTestRepository.save(student);
        return student.getName() + " is created";
    }

    public Optional<Student> getStudent(int number){
        return webTestRepository.findById(number);
    }

    public String changeLevel(int id){
        Optional<Student> student = getStudent(id);
        student.get().setLevel(Level.FINAL);
        return "level successfully changed";
    }

}
