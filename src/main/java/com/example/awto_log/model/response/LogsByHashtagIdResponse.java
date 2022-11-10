package com.example.awto_log.model.response;

import com.example.awto_log.model.LogEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LogsByHashtagIdResponse {
    private List<LogEntity> logs;
}
