package com.example.checkit.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class LitigationDto {

    private Long id;

    @NotBlank(message = "litigation title shouldn't be empty")
    private String litigationTitle;

    private LocalDateTime createdDate;

    @NotBlank(message = "litigation detail shouldn't be empty")
    @Max(value = 500, message = "litigation detail shouldn't be over 500 words")
    private String litigationDetail;

    private Boolean resolvedStatus;

    private ClientDto clientDto;

}
