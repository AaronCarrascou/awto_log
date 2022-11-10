package com.example.awto_log.controller;

import com.example.awto_log.model.request.CreateLogRequest;
import com.example.awto_log.model.request.UpdateHashtagByIdRequest;
import com.example.awto_log.model.response.CreateLogResponse;
import com.example.awto_log.model.response.LogsByHashtagIdResponse;
import com.example.awto_log.model.response.UpdateHashtagByIdResponse;
import com.example.awto_log.service.AwtoLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class awtoLogController {

    private AwtoLogService awtoLogService;

    @PostMapping("/logs")
    public ResponseEntity<CreateLogResponse> createLog(@RequestBody CreateLogRequest request){
        return ResponseEntity.ok(awtoLogService.createLog(request));
    }

    @PutMapping ("/hashtags")
    public ResponseEntity<UpdateHashtagByIdResponse> updateHashtagById(@RequestBody UpdateHashtagByIdRequest request){
        return ResponseEntity.ok(awtoLogService.updateHashtagById(request));
    }

    @GetMapping ("/logs/hashtag/{hashtagId}")
    public ResponseEntity<LogsByHashtagIdResponse>  logsByHashtagId(@PathVariable int hashtagId){
        return ResponseEntity.ok(awtoLogService.logsByHashtagId(hashtagId));
    }

    @GetMapping("/example")
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok("OK");
    }
}
