package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Accessors(chain = true)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.STRING)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    protected Long id;

    @Column(name="first_name")
    protected String firstname;

    @Column(name="surname")
    protected String surname;

    @Column(name="phoneNumber")
    protected String phoneNumber;

    protected String email;

    protected  String password;


    protected Boolean activeStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @Embedded
    protected Address address;


    protected Float accountBalance;


    protected String role;

    @Column(name="profilURL")
    protected String profileUrl;


}
