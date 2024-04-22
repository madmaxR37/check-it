package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@MappedSuperclass
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    protected Integer id;

    @Column(name="first_name")
    protected String firstname;

    @Column(name="surname")
    protected String surname;

    @Column(name="phoneNumber")
    protected String phoneNumber;


    protected Boolean activeStatus;


    @Embedded
    protected Address address;


    protected Float accountBalance;


    protected String role;

    @Column(name="profilURL")
    protected String profileUrl;


}
