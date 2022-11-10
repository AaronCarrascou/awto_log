package com.example.awto_log.model.DTO;

import com.example.awto_log.model.HashtagEntity;
import com.example.awto_log.model.LogEntity;
import lombok.Data;

@Data
public class HashtagLogDTO {
    private Integer hashtagLogId;
    private LogEntity logEntity;
    private HashtagEntity hashtagEntity;
}
