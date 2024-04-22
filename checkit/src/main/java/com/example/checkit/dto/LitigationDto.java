package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LitigationDto {

    private Integer id;

    private String litigationTitle;

    private String litigationDetail;

    private Boolean resolvedStatus;

}
