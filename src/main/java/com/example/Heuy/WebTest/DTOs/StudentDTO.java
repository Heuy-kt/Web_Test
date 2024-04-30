package com.example.Heuy.WebTest.DTOs;

import com.example.Heuy.WebTest.enums.Level;

public record StudentDTO(
        String name,
        String MatNo,
        Level level
) {
}
