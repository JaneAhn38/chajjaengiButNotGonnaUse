package com.anyonehere.chajjaengi.service;

import com.anyonehere.chajjaengi.entity.Spot;
import com.anyonehere.chajjaengi.entity.SpotPresence;
import com.anyonehere.chajjaengi.repository.SpotPresenceRepository;
import
        com.anyonehere.chajjaengi.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpotService {

    private final SpotRepository spotRepository;
    private final SpotPresenceRepository
            spotPresenceRepository;

    public SpotService(SpotRepository spotRepository,
                       SpotPresenceRepository spotPresenceRepository) {
        this.spotRepository = spotRepository;
        this.spotPresenceRepository =
                spotPresenceRepository;
    }

    public List<Map<String, Object>> getSpotList() {
        List<Spot> spots = spotRepository.findAll();
        Map<Long, Integer> presenceMap =
                spotPresenceRepository.findAll()
                        .stream()

                        .collect(Collectors.toMap(SpotPresence::getSpotId,
                                SpotPresence::getActiveUserCount));

        return spots.stream().map(spot -> {
            Map<String, Object> map = new
                    java.util.HashMap<>();
            map.put("spotId", spot.getSpotId());
            map.put("name", spot.getName());
            map.put("latitude", spot.getLatitude());
            map.put("longitude", spot.getLongitude());
            map.put("activeUserCount",
                    presenceMap.getOrDefault(spot.getSpotId(), 0));
            return map;
        }).collect(Collectors.toList());
    }
}