package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto {

    protected Integer id;

    protected String firstname;

    protected String surname;

    protected String phoneNumber;

    protected Boolean activeStatus;

    protected AddressDto addressDto;

    protected Float accountBalance;

    protected String role;

    protected String profileUrl;


}
