package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDto {

    protected Long id;

    protected String firstname;

    protected String surname;

    protected String phoneNumber;

    protected String email;

    protected String password;

    protected Boolean activeStatus;

    protected AddressDto addressDto;

    protected Float accountBalance;

    protected Date createdDate;

    protected String role;

    protected String profileUrl;


}
