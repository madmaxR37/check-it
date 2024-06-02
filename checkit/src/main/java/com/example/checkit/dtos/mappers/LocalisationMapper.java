package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.LocalisationDto;
import com.example.checkit.models.Localisation;

public class LocalisationMapper {

    public static Localisation localisationDtoToLocalisation(LocalisationDto localisationDto){
        return new Localisation()
                .setLocalisationLatitude(localisationDto.getLocalisationLatitude())
                .setLocalisationLongitude(localisationDto.getLocalisationLongitude())
                .setLocalisationName(localisationDto.getLocalisationName());
    }
    public static LocalisationDto localisationToLocalisationDto(Localisation localisation){
        return new LocalisationDto()
                .setLocalisationLatitude(localisation.getLocalisationLatitude())
                .setLocalisationLongitude(localisation.getLocalisationLongitude())
                .setLocalisationName(localisation.getLocalisationName());
    }

}
