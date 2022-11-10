package com.example.awto_log.repository;

import com.example.awto_log.model.HashtagLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface HashtagLogRepository extends JpaRepository<HashtagLogEntity, Integer> {
    @Query(nativeQuery = true, value = "SELECT aw_hashtag_log.log_id FROM aw_hashtag_log WHERE aw_hashtag_log.hashtag_id=:hashtagId")
    List<Integer> findLogIdsByHashtagId(@PathVariable int hashtagId);
}
