package com.example.checkit.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class DeliveryManDto extends UserDto {

    private List<String> nicImagesUrls;

    private List<String> drivingLicenseUrls;

    private VehicleDto vehicleDto;

}
