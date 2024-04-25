package com.example.Heuy.WebTest.entites;

import com.example.Heuy.WebTest.enums.Level;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private Integer age;
    private String matNo;
    @Enumerated(EnumType.STRING)
    private Level level;

}
