package com.example.checkit.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    protected LocalDateTime createdDate;

    @Column(name = "status")
    protected Boolean status;

    @OneToOne
    protected OrderEntity orderEntity;

    @OneToOne
    @JoinColumn(name = "preorder_id")
    protected PreOrder preOrder;

    @OneToOne
    @JoinColumn(name = "senderid")
    protected User sender;

    @OneToOne
    @JoinColumn(name = "receiverid")
    protected User receiver;

}
