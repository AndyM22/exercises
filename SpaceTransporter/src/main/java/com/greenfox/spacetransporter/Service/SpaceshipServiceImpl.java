package com.greenfox.spacetransporter.Service;

import com.greenfox.spacetransporter.Model.Planet;
import com.greenfox.spacetransporter.Model.Spaceship;
import com.greenfox.spacetransporter.Repository.PlanetRepository;
import com.greenfox.spacetransporter.Repository.SpaceshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceshipServiceImpl implements SpaceshipService {

    private SpaceshipRepository spaceshipRepository;
    private PlanetRepository planetRepository;

    @Autowired
    public SpaceshipServiceImpl(SpaceshipRepository spaceshipRepository, PlanetRepository planetRepository) {
        this.spaceshipRepository = spaceshipRepository;
        this.planetRepository = planetRepository;
    }

    @Override
    public void embarkPeople(Planet planet, Spaceship spaceship) {
        if (planet.getPopulation() > 0) {
            int maxSpace = spaceship.getMax_capacity() - spaceship.getUtilization();
            if (maxSpace > planet.getPopulation()) {
                spaceship.setUtilization((int) (spaceship.getUtilization() + planet.getPopulation()));
                planet.setPopulation(0);
            } else if (maxSpace < planet.getPopulation()) {
                spaceship.setUtilization(spaceship.getMax_capacity());
                planet.setPopulation(planet.getPopulation() - maxSpace);
            }
        }
        this.spaceshipRepository.save(spaceship);
        this.planetRepository.save(planet);
    }

    @Override
    public void disembarkPeople(Planet planet, Spaceship spaceship) {
        planet.setPopulation(planet.getPopulation() + spaceship.getUtilization());
        this.planetRepository.save(planet);
        spaceship.setUtilization(0);
        this.spaceshipRepository.save(spaceship);
    }

    @Override
    public Spaceship getSpaceshipById(long id) {
        return this.spaceshipRepository.getOne(id);
    }

    @Override
    public void updateSpaceship(Spaceship spaceship) {
        this.spaceshipRepository.save(spaceship);
    }

}
