package com.example.swaggercodegenexample.repositories;

import com.example.swaggercodegenexample.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
