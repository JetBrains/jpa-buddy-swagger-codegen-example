package com.example.swaggercodegenexample.services;

import com.example.swaggercodegenexample.model.Visit;
import com.example.swaggercodegenexample.repositories.VisitRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getVisitsFromInterval(OffsetDateTime start, OffsetDateTime end) {
        return visitRepository.findByDateBetween(start, end);
    }
}
