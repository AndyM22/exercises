package com.greenfox.spacetransporter.Service;


import com.greenfox.spacetransporter.Model.Planet;

import java.util.List;

public interface PlanetService {

    List<Planet> getAllPlanets();

    Planet getPlanetById(long id);

}
