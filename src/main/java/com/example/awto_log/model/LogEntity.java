package com.example.awto_log.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
@Table (name = "aw_log")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer logId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", length = 0)
    private Date logCreationDate;

    @Basic
    @Column(name = "host")
    private String logHost;

    @Basic
    @Column(name = "details")
    private String logDetails;

}
