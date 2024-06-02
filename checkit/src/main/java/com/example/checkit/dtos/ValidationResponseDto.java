package com.example.checkit.dtos;

import java.util.Map;

public record ValidationResponseDto(Map<String, String> errors) {
}
