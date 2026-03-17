package com.anyonehere.chajjaengi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spots")
public class Spot {

    @Id
    @Column(name = "spot_id")
    private Long spotId;

    @Column(name = "spot_name")
    private String name;
    private Double latitude;
    private Double longitude;

    @Column(name = "radius_m")
    private Integer radiusM;

    public Long getSpotId() { return spotId; }
    public String getName() { return name; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public Integer getRadiusM() { return radiusM; }
}