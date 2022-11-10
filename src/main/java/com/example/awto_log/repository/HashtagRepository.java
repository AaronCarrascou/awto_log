package com.example.awto_log.repository;

import com.example.awto_log.model.HashtagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface HashtagRepository extends JpaRepository<HashtagEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT aw_hashtag.id FROM aw_hashtag WHERE aw_hashtag.description=:hashtagDescription")
    int findIdByHashtagDescription(String hashtagDescription);
}
