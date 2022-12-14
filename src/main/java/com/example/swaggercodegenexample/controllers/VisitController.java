package com.example.swaggercodegenexample.controllers;

import com.example.swaggercodegenexample.dtos.VisitWithPetDto;
import com.example.swaggercodegenexample.mappers.VisitMapper;
import com.example.swaggercodegenexample.services.VisitService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/statistics")
public class VisitController {
    private final VisitService visitService;
    private final VisitMapper visitMapper;

    //In case you have warning from IJ for VisitMapper – just disable it. It's IJ bug.
    public VisitController(VisitService visitService,
                           VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @GetMapping("/from-interval")
    public List<VisitWithPetDto> getVisitsFromInterval(@RequestParam("start")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                       OffsetDateTime start,
                                                       @RequestParam("end")
                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                       OffsetDateTime end) {
        return visitService.getVisitsFromInterval(start, end)
                           .stream()
                           .map(visitMapper::toDto)
                           .collect(Collectors.toList());
    }
}
