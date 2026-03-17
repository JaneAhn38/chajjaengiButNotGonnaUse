package com.anyonehere.chajjaengi.repository;

import com.anyonehere.chajjaengi.entity.SpotPresence;
import
        org.springframework.data.jpa.repository.JpaRepository;

public interface SpotPresenceRepository extends
        JpaRepository<SpotPresence, Long> {
}