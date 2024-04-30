package com.example.checkit.dto;

import com.example.checkit.model.DeliveryMan;
import com.example.checkit.model.Seller;
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
