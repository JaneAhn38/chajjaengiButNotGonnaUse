package com.anyonehere.chajjaengi.controller;

import com.anyonehere.chajjaengi.service.SpotService;
import
        org.springframework.web.bind.annotation.GetMapping;
import
        org.springframework.web.bind.annotation.RequestMapping;
import
        org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SpotController {

    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping("/spots")
    public List<Map<String, Object>> getSpots() {
        return spotService.getSpotList();
    }
}