package com.anyonehere.chajjaengi.repository;

import com.anyonehere.chajjaengi.entity.Spot;
import
        org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends
        JpaRepository<Spot, Long> {
}