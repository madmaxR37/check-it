package com.example.checkit.model;

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
}
