package com.aryan.BMS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private String description;
    private int length;
    private double rating;
    private Date releaseDate;

    @OneToMany
    private List<Show> shows;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection // M:M mapping with enums
    @Enumerated(EnumType.STRING)
    private List<Language> languages;
    @ElementCollection // M:M mapping with enums
    @Enumerated(EnumType.STRING)
    private List<Feature> movieFeatures;


}

/* Movie : Shows -> 1:M
* Movie : Actor -> M:M
* Movie : Language -> M:M
* Movie : features -> M:M*/
