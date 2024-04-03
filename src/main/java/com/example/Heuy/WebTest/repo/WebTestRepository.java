package com.example.Heuy.WebTest.repo;

import com.example.Heuy.WebTest.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebTestRepository extends JpaRepository<Student, Integer> {

}
