package com.greenfox.spacetransporter.Service;

import com.greenfox.spacetransporter.Model.Planet;
import com.greenfox.spacetransporter.Repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    private PlanetRepository planetRepository;

    @Autowired
    public PlanetServiceImpl(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }


    @Override
    public List<Planet> getAllPlanets() {
        return this.planetRepository.findAll();
    }

    @Override
    public Planet getPlanetById(long id) {
        return this.planetRepository.getOne(id);
    }

}
