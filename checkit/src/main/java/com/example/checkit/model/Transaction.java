package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    protected Integer id;

    @Column(name = "amount")
    protected Float amount;

    @Column(name = "date")
    protected Date date;

    @Column(name = "status")
    protected Boolean status;

    @OneToOne
    @JoinColumn(name = "preorder_id")
    protected PreOrder preOrder;


}
