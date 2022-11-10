package com.example.awto_log.service;

import com.example.awto_log.model.request.CreateLogRequest;
import com.example.awto_log.model.request.UpdateHashtagByIdRequest;
import com.example.awto_log.model.response.CreateLogResponse;
import com.example.awto_log.model.response.LogsByHashtagIdResponse;
import com.example.awto_log.model.response.UpdateHashtagByIdResponse;

public interface AwtoLogService {
    CreateLogResponse createLog(CreateLogRequest request);

    public LogsByHashtagIdResponse logsByHashtagId(int hashtagId);

    UpdateHashtagByIdResponse updateHashtagById(UpdateHashtagByIdRequest request);
}
