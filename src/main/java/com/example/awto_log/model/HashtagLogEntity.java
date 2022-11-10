package com.example.awto_log.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
@Table (name = "aw_hashtag_log")
public class HashtagLogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer hashtagLogId;

    @ManyToOne
    @JoinColumn(name = "log_id")
    private LogEntity logEntity;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    private HashtagEntity hashtagEntity;
}
