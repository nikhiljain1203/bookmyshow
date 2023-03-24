package com.example.bookmyshow.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;

    @OneToMany
    private List<Auditorium> auditoriums;

    @ManyToOne
    private City city;
}
