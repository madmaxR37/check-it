package com.example.checkit.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class UserDto {

    protected Long id;

    @NotBlank(message = "specify the user first name")
    protected String firstname;

    @NotBlank(message = "specify the user last name")
    protected String surname;

    @Min(value = 9 , message = "enter a valid number")
    protected String phoneNumber;

    @NotBlank(message = "specify the user's email address")
    @Email(message = "Enter a validate email")
    protected String email;

    protected String password;

    protected Boolean activeStatus;

    protected AddressDto addressDto;

    protected Float accountBalance;

    protected LocalDateTime createdDate;

    protected String role;

    protected String profileUrl;


}
