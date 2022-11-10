package com.example.awto_log.model.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class LogDTO {
    private Integer logId;
    private Date logCreationDate;
    private String logHost;
    private String logDetails;
}
