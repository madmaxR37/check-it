package com.example.checkit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class CreditCard extends Transaction{

    @Column(name = "cartnumber")
    private String creditCartNumber;

    @Column(name = "cvv")
    private String cvv;

    private String expDate;
}
