package com.greenfox.gfclub.Repository;

import com.greenfox.gfclub.Model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    Drink findByName(String name);

}
