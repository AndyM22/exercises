package com.greenfox.gfclub.Repository;

import com.greenfox.gfclub.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Food findByName(String name);

}
