package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Drink;
import com.greenfox.gfclub.Repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    private DrinkRepository drinkRepository;

    @Autowired
    public DrinkServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Drink getDrinkByName(String name) {
        return this.drinkRepository.findByName(name);
    }

    @Override
    public Drink getDrinkById(Long id) {
        return this.drinkRepository.findById(id).get();
    }

    @Override
    public List<Drink> getAllDrinks() {
        return this.drinkRepository.findAll();
    }

    @Override
    public List<String> getAllDrinksName() {
        return getAllDrinks().stream()
                .map(Drink::getName)
                .collect(Collectors.toList());
    }
}
