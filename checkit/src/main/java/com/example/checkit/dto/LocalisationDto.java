package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LocalisationDto {

    private String localisationName;

    private  Long localisationLongitude;

    private Long localisationLatitude;
}
