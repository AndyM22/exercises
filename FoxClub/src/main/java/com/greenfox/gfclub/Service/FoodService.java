package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Food;

import java.util.List;

public interface FoodService {

    Food getFoodByName(String name);

    Food getFoodById(Long id);

    List<Food> getAllFood();

    List<String> getAllFoodNAmes();

}
