package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Accessors(chain = true)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.STRING)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    protected Long id;

    protected String firstname;


    protected String last_name;

    @Column(unique = true)
    protected String phoneNumber;


    @Column(unique = true)
    protected String email;

    protected  String password;


    protected Boolean activeStatus;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDateTime createdDate;

    @Embedded
    protected Address address;


    protected Float accountBalance;


    protected String role;

    @Column(name="profilURL")
    protected String profileUrl;


}
