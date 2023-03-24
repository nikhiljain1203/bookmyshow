package com.example.bookmyshow.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

// 1:M
// 1:1

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> auditoriumFeatures;
}

// auditoriums                        // auditorium_features
// id | name | feature_id             //  id | value
// 1 | audi-1 |
