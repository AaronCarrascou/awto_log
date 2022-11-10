package com.example.awto_log.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateLogRequest {
    private String host;
    private String details;
    private List<String> hashtags;
}
