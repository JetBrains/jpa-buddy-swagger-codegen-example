package com.example.swaggercodegenexample.controllers;

import com.example.swaggercodegenexample.mappers.PetMapper;
import com.example.swaggercodegenexample.services.PetSyncService;
import com.swagger.client.codegen.rest.model.PetDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {
    private final PetSyncService petSyncService;
    private final PetMapper petMapper;

    public PetController(PetSyncService petSyncService,
                         PetMapper petMapper) {
        this.petSyncService = petSyncService;
        this.petMapper = petMapper;
    }

    @GetMapping("/sync")
    public PetDto syncPetById(@RequestParam("id") Long id) {
        return petMapper.toDto(petSyncService.syncPetById(id));
    }
}
