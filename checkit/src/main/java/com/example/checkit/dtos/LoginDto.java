package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginDto {

    private String credential;

    private String password;

}
