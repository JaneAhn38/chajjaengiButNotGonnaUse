package com.anyonehere.chajjaengi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "spot_presence")
public class SpotPresence {

    @Id
    @Column(name = "spot_id")
    private Long spotId;

    @Column(name = "active_user_count")
    private Integer activeUserCount;

    @Column(name = "calculated_at")
    private LocalDateTime calculatedAt;

    public Long getSpotId() { return spotId; }
    public Integer getActiveUserCount() { return
            activeUserCount; }
    public LocalDateTime getCalculatedAt() { return
            calculatedAt; }
}