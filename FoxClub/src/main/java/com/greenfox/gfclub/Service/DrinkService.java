package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Drink;

import java.util.List;

public interface DrinkService {

    Drink getDrinkByName(String name);

    Drink getDrinkById (Long id);

    List<Drink> getAllDrinks();

    List<String> getAllDrinksName();

}
