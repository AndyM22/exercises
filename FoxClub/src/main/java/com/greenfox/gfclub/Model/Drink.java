package com.greenfox.gfclub.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Drink {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany (mappedBy = "drink")
    private List<Fox> foxes;

    public Drink() {
    }

    public Drink(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public List<Fox> getFoxes() {
        return foxes;
    }

    public void setFoxes(List<Fox> foxes) {
        this.foxes = foxes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
