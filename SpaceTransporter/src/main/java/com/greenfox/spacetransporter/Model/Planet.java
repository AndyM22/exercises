package com.greenfox.spacetransporter.Model;

import javax.persistence.*;

@Entity
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long population;
    @OneToOne(mappedBy = "planet")
    private Spaceship spaceship;

    public Planet() {
    }

    public Planet(String name, int population) {
        this.name = name;
        this.population = population;
        id = 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
}
