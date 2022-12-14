package com.example.swaggercodegenexample.model;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "veterinarian_name")
    private String veterinarianName;

    @Column(name = "clinic_name")
    private String clinicName;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public Pet getPet() {return pet;}

    public void setPet(Pet pet) {this.pet = pet;}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public OffsetDateTime getDate() {return date;}

    public void setDate(OffsetDateTime date) {this.date = date;}

    public String getVeterinarianName() {return veterinarianName;}

    public void setVeterinarianName(String veterinarianName) {this.veterinarianName = veterinarianName;}

    public String getClinicName() {return clinicName;}

    public void setClinicName(String clinicName) {this.clinicName = clinicName;}
}
