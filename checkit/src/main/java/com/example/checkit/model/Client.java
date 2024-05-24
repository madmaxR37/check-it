package com.example.checkit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@Entity
@DiscriminatorValue("client")
public class Client extends User{

    @OneToMany(mappedBy = "client")
    private List<Cart> carts;
}
