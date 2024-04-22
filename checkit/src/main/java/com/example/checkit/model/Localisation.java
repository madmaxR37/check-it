package com.example.checkit.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Embeddable
@Data
public class Localisation {

    private String localisationName;

    private  Long localisationLongitude;

    private Long localisationLatitude;
}
