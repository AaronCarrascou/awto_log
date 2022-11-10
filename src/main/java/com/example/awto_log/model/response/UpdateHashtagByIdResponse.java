package com.example.awto_log.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateHashtagByIdResponse {
    private int hashtagId;
    private String newDescription;
}
