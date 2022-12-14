package com.example.swaggercodegenexample.dtos;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * A DTO for the {@link com.example.swaggercodegenexample.model.Visit} entity
 */
public class VisitWithPetDto implements Serializable {
    private final Long id;
    private final PetDto pet;
    private final OffsetDateTime date;

    public VisitWithPetDto(Long id,
                           PetDto pet,
                           OffsetDateTime date) {
        this.id = id;
        this.pet = pet;
        this.date = date;
    }

    public Long getId() {return id;}

    public PetDto getPet() {return pet;}

    public OffsetDateTime getDate() {return date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VisitWithPetDto entity = (VisitWithPetDto) o;
        return Objects.equals(this.id, entity.id) && Objects.equals(this.pet, entity.pet) && Objects.equals(this.date,
                                                                                                            entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pet, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + "id = " + id + ", " + "pet = " + pet + ", " + "date = " + date + ")";
    }

    /**
     * A DTO for the {@link com.example.swaggercodegenexample.model.Pet} entity
     */
    public static class PetDto implements Serializable {
        private final Long id;
        private final Long userId;
        private final String name;

        public PetDto(Long id,
                      Long userId,
                      String name) {
            this.id = id;
            this.userId = userId;
            this.name = name;
        }

        public Long getId() {return id;}

        public Long getUserId() {return userId;}

        public String getName() {return name;}

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PetDto entity = (PetDto) o;
            return Objects.equals(this.id, entity.id) && Objects.equals(this.userId, entity.userId) && Objects.equals(
                    this.name, entity.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userId, name);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" + "id = " + id + ", " + "userId = " + userId + ", " + "name = " + name + ")";
        }
    }
}
