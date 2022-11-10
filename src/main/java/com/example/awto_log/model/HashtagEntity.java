package com.example.awto_log.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
@Table (name = "aw_hashtag")
public class HashtagEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer hashtagId;

    @Basic
    @Column(name = "description")
    private String hashtagDescription;
}
