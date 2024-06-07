package com.example.checkit.controllers;

import com.example.checkit.handlers.ResponseHandler;
import com.example.checkit.services.externalServices.GraphHopperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeocodingController {
    private final GraphHopperService graphHopperService;

    public GeocodingController(GraphHopperService graphHopperService) {
        this.graphHopperService = graphHopperService;
    }

    @GetMapping("/geocode")
    public ResponseEntity<Object> geoCode(@RequestParam String address){
        Object object = graphHopperService.geoCode(address);
        return ResponseHandler.generateResponseData("data", HttpStatus.OK,object);
    }
}
