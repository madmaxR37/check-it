package com.example.checkit.dtos;

import com.example.checkit.models.DeliveryMan;
import com.example.checkit.models.Seller;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
public class DeliveryMenDto {

    private Long id;

    private List<DeliveryMan> deliveryMEN;

    private Seller seller;
}
