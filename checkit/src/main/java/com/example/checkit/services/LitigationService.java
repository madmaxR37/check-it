package com.example.checkit.services;

import com.example.checkit.dtos.LitigationDto;

import java.util.List;

public interface LitigationService {

    LitigationDto createLitigation(LitigationDto litigationDto);

    LitigationDto updateLitigation(LitigationDto litigationDto);

    LitigationDto findLitigationById(Long id);

    List<LitigationDto> findAll();

    void deleteLitigation(Long id);
}
