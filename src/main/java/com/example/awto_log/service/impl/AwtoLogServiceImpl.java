package com.example.awto_log.service.impl;

import com.example.awto_log.model.HashtagEntity;
import com.example.awto_log.model.HashtagLogEntity;
import com.example.awto_log.model.LogEntity;
import com.example.awto_log.model.request.CreateLogRequest;
import com.example.awto_log.model.request.UpdateHashtagByIdRequest;
import com.example.awto_log.model.response.CreateLogResponse;
import com.example.awto_log.model.response.LogsByHashtagIdResponse;
import com.example.awto_log.model.response.UpdateHashtagByIdResponse;
import com.example.awto_log.repository.HashtagLogRepository;
import com.example.awto_log.repository.HashtagRepository;
import com.example.awto_log.repository.LogRepository;
import com.example.awto_log.service.AwtoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AwtoLogServiceImpl implements AwtoLogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private HashtagRepository hashtagRepository;

    @Autowired
    private HashtagLogRepository hashtagLogRepository;

    private DateFormat dateFormat;

    @Override
    public LogsByHashtagIdResponse logsByHashtagId(int hashtagId){

        LogsByHashtagIdResponse response = new LogsByHashtagIdResponse();

        List<LogEntity> logs = new ArrayList<>();

        //Se obtienes los ids de los logs según el  id entregado
        List<Integer> logIds = hashtagLogRepository.findLogIdsByHashtagId(hashtagId);

        //Se agregan a la lista de logs los ids obtenidos
        for (int id: logIds){
            logs.add(logRepository.findById(id).get());
        }

        response.setLogs(logs);

        return response;
    }
    @Override
    public UpdateHashtagByIdResponse updateHashtagById(UpdateHashtagByIdRequest request){

        boolean exists = hashtagRepository.existsById(request.getId());

        UpdateHashtagByIdResponse response = new UpdateHashtagByIdResponse();

        //Se verifica si existe un Hashtag con el Id entregado en el request
        if(exists){

            //Si existe se asigna al modelo y setea los datos para luego guardarlo
            HashtagEntity hashtag = hashtagRepository.findById(request.getId()).get();
            hashtag.setHashtagDescription(request.getDescription());

            hashtagRepository.save(hashtag);

            response.setHashtagId(hashtag.getHashtagId());
            response.setNewDescription(hashtag.getHashtagDescription());

            return response;
        }

        return null;
    }

    //No se logró implementar
    @Override
    public CreateLogResponse createLog(CreateLogRequest request){

        CreateLogResponse response = new CreateLogResponse();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashtagEntity newHashtag = new HashtagEntity();
        HashtagLogEntity newHashtagLog = new HashtagLogEntity();
        LogEntity newLog = new LogEntity();

        newLog.setLogCreationDate(new Date(System.currentTimeMillis()));
        newLog.setLogHost(request.getHost());
        newLog.setLogDetails(request.getDetails());

        newHashtagLog.setLogEntity(newLog);

        // int idCreatedLog=logRepository.saveAndFlush(log).getLogId();
        List<String> hashtags = request.getHashtags();
        for(String hashtag: hashtags){

            newHashtag.setHashtagDescription(hashtag);

            newHashtagLog.setHashtagEntity(hashtagRepository.saveAndFlush(newHashtag));

        }

        hashtagLogRepository.save(newHashtagLog);

        return null;
    }
}
