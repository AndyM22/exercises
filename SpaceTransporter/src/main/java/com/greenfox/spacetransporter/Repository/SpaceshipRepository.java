package com.greenfox.spacetransporter.Repository;

import com.greenfox.spacetransporter.Model.Spaceship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
}
