package com.example.checkit.service;

import com.example.checkit.dto.LitigationDto;

import java.util.List;

public interface LitigationService {

    LitigationDto createLitigation(LitigationDto litigationDto);

    LitigationDto updateLitigation(LitigationDto litigationDto);

    LitigationDto findLitigationById(Long id);

    List<LitigationDto> findAll();

    void deleteLitigation(Long id);
}
