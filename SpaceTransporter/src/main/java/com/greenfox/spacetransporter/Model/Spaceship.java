package com.greenfox.spacetransporter.Model;

import javax.persistence.*;

@Entity
public class Spaceship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int max_capacity;
    private int utilization;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private Planet planet;

    public Spaceship() {
    }

    public Spaceship(int max_capacity, int utilization) {
        this.max_capacity = max_capacity;
        this.utilization = utilization;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getUtilization() {
        return utilization;
    }

    public void setUtilization(int utilization) {
        this.utilization = utilization;
    }

    public long getId() {
        return id;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
