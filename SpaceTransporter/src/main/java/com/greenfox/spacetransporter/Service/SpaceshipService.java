package com.greenfox.spacetransporter.Service;

import com.greenfox.spacetransporter.Model.Planet;
import com.greenfox.spacetransporter.Model.Spaceship;

public interface SpaceshipService {

    void embarkPeople(Planet planet, Spaceship spaceship);

    void disembarkPeople(Planet planet, Spaceship spaceship);

    Spaceship getSpaceshipById(long id);

    void updateSpaceship(Spaceship spaceship);

}
