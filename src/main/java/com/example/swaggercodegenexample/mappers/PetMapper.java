package com.example.swaggercodegenexample.mappers;

import com.example.swaggercodegenexample.model.Pet;
import com.swagger.client.codegen.rest.model.PetDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PetMapper {
    Pet toEntity(com.swagger.client.codegen.rest.model.PetDto petDto);

    PetDto toDto(Pet pet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pet partialUpdate(PetDto petDto, @MappingTarget Pet pet);
}
