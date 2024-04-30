package com.example.checkit.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class LitigationDto {

    private Long id;

    private String litigationTitle;

    private Date createdDate;

    private String litigationDetail;

    private Boolean resolvedStatus;

    private ClientDto clientDto;

}
