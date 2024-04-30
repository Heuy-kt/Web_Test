package com.example.Heuy.WebTest.services;

import com.example.Heuy.WebTest.DTOs.StudentDTO;
import com.example.Heuy.WebTest.entites.Student;
import com.example.Heuy.WebTest.enums.Level;
import com.example.Heuy.WebTest.repo.WebTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WebService {

    private final WebTestRepository webTestRepository;

    //create a student
    public ResponseEntity<String> createStudent(Student student){
        webTestRepository.save(student);
        return new ResponseEntity<>(student.getName() + " is created", HttpStatus.CREATED);
    }

    public ResponseEntity<Optional<Student>> getStudent(long number){
        return new ResponseEntity<>(webTestRepository.findById(number), HttpStatus.OK);
    }

    public ResponseEntity<Optional<StudentDTO>> findFriendStudent(long id){
        Optional<Student> student = webTestRepository.findById(id);
        StudentDTO studentDTO = new StudentDTO(student.get().getName(), student.get().getMatNo(), student.get().getLevel());
        return new ResponseEntity<>(Optional.of(studentDTO), HttpStatus.OK);
    }

    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(webTestRepository.findAll(), HttpStatus.OK);

    }

    public ResponseEntity<Level> changeLevel(long id, Level newLevel){
        webTestRepository.updateLevel(id, newLevel);
        return new ResponseEntity<>(newLevel, HttpStatus.OK);
    }

}
