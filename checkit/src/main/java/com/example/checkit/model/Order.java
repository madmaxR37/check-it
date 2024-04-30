package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
@Accessors(chain = true)
@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long id;

    @Column(name = "order_status")
    private Boolean status;

    @Column(name = "created_date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name = "pre_order_id")
    private PreOrder preOrder;

    @OneToOne(mappedBy = "order")
    private Delivery delivery;

}
