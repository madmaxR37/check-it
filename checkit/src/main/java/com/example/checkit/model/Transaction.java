package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionid")
    protected Long id;

    @Column(name = "amount")
    protected Float amount;

    @Column(name = "createdDate")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdDate;

    @Column(name = "status")
    protected Boolean status;

    @OneToOne
    @JoinColumn(name = "preorder_id")
    protected PreOrder preOrder;

    @OneToOne(mappedBy = "transaction")
    protected Order order;


}
