package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LogInResponse {

    private String token;

}
