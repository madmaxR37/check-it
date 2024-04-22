package com.example.checkit.dto.mappers;

import com.example.checkit.dto.LitigationDto;
import com.example.checkit.model.Litigation;

public class LitigationMapper {

    public static Litigation litigationDtoToLitigation(LitigationDto litigationDto){
        return new Litigation()
                .setLitigationTitle(litigationDto.getLitigationTitle())
                .setLitigationDetail(litigationDto.getLitigationDetail())
                .setResolvedStatus(litigationDto.getResolvedStatus());
    }

    public static LitigationDto litigationToLitigationDto(Litigation litigation){
        return new LitigationDto()
                .setLitigationTitle(litigation.getLitigationTitle())
                .setLitigationDetail(litigation.getLitigationDetail())
                .setResolvedStatus(litigation.getResolvedStatus());
    }
}
