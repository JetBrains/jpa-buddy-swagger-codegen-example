package com.example.swaggercodegenexample.services;

import com.example.swaggercodegenexample.mappers.PetMapper;
import com.example.swaggercodegenexample.model.Pet;
import com.example.swaggercodegenexample.repositories.PetRepository;
import org.springframework.stereotype.Service;
import com.swagger.client.codegen.rest.api.PetApi;
import com.swagger.client.codegen.rest.model.PetDto;

import javax.persistence.EntityNotFoundException;

@Service
public class PetSyncService {
    private final PetApi petApi;
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public PetSyncService(PetApi petApi,
                          PetRepository petRepository,
                          PetMapper petMapper) {
        this.petApi = petApi;
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public Pet syncPetById(Long id) {
        return petRepository.existsById(id) ? updatePetById(id) : addPet(id);
    }

    private Pet addPet(Long id) {
        PetDto petDto = petApi.getPetById(id);
        Pet pet = petMapper.toEntity(petDto);
        return petRepository.save(pet);
    }

    private Pet updatePetById(Long id) {
        Pet pet = petRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Pet updatedPet = petMapper.partialUpdate(petApi.getPetById(id), pet);
        return petRepository.save(updatedPet);
    }
}
