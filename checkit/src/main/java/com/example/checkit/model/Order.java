package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
@Accessors(chain = true)
@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer id;

    @Column(name = "order_status")
    private Boolean status;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

}
