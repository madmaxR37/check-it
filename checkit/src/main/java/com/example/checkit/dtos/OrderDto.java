package com.example.checkit.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class OrderDto {

    private Long id;

    private Boolean status;

    private LocalDateTime createdDate;

    private PreOrderDto preOrderDto;

}
