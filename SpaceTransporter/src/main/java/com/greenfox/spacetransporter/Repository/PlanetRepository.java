package com.greenfox.spacetransporter.Repository;

import com.greenfox.spacetransporter.Model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

}
