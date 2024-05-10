package com.example.Heuy.WebTest.repo;

import com.example.Heuy.WebTest.entites.Student;
import com.example.Heuy.WebTest.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WebTestRepository extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.level = :level WHERE s.id = :id ")
    void updateLevel(Long id, Level level);
}
