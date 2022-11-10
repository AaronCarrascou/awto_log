package com.example.awto_log.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateHashtagByIdRequest {
    private int id;
    private String description;
}
