package com.example.swaggercodegenexample.mappers;

import com.example.swaggercodegenexample.dtos.VisitWithPetDto;
import com.example.swaggercodegenexample.model.Visit;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VisitMapper {
    @Mapping(source = "pet.userId", target = "pet.user.id")
    Visit toEntity(VisitWithPetDto visitWithPetDto);

    @Mapping(source = "pet.user.id", target = "pet.userId")
    VisitWithPetDto toDto(Visit visit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "pet.userId", target = "pet.user.id")
    Visit partialUpdate(VisitWithPetDto visitWithPetDto, @MappingTarget Visit visit);
}
