package com.example.checkit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Mobile extends Transaction{

    @Column(name = "mobilenumber")
    private String number;
}
