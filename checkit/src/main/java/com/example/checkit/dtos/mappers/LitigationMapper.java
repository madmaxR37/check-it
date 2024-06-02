package com.example.checkit.dtos.mappers;

import com.example.checkit.dtos.LitigationDto;
import com.example.checkit.models.Litigation;

import java.util.ArrayList;
import java.util.List;

public class LitigationMapper {
    public static List<Litigation> litigationDtoToLitigation(List<LitigationDto> litigationDtos){
       List<Litigation> litigationList = new ArrayList<>();

       for (LitigationDto litigationDto: litigationDtos){
           Litigation litigation = new Litigation();
           litigation
                   .setLitigationDetail(litigationDto.getLitigationDetail())
                   .setLitigationTitle(litigationDto.getLitigationTitle())
                   .setResolvedStatus(litigationDto.getResolvedStatus())
                   .setClient(ClientMapper.clientDtoToClient(litigationDto.getClientDto()));
           litigationList.add(litigation);
       }


        return litigationList;
    }

    public static List<LitigationDto> litigationToLitigationDto(List<Litigation> litigations){

        List<LitigationDto> litigationDtos =new ArrayList<>();

        for (Litigation litigation: litigations){
            LitigationDto litigationDto = new LitigationDto();
            litigationDto
                    .setId(litigation.getId())
                    .setCreatedDate(litigation.getCreatedDate())
                    .setLitigationTitle(litigation.getLitigationTitle())
                    .setLitigationDetail(litigation.getLitigationDetail())
                    .setResolvedStatus(litigation.getResolvedStatus())
                    .setClientDto(ClientMapper.clientToClientDto(litigation.getClient()));
            litigationDtos.add(litigationDto);
        }

        return litigationDtos;
    }
}
