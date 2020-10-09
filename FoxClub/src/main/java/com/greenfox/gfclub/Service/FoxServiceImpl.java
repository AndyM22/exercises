package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Drink;
import com.greenfox.gfclub.Model.Food;
import com.greenfox.gfclub.Model.Fox;
import com.greenfox.gfclub.Repository.DrinkRepository;
import com.greenfox.gfclub.Repository.FoodRepository;
import com.greenfox.gfclub.Repository.FoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxServiceImpl implements FoxService {

    private FoxRepository foxRepository;
    private DrinkRepository drinkRepository;
    private FoodRepository foodRepository;

    @Autowired
    public FoxServiceImpl(FoxRepository foxRepository, DrinkRepository drinkRepository, FoodRepository foodRepository) {
        this.foxRepository = foxRepository;
        this.drinkRepository = drinkRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFox(Fox fox) {
        this.foxRepository.save(fox);
    }

    @Override
    public void addFoxByName(String foxName) {
        Fox fox = new Fox(foxName);
        Drink drink = this.drinkRepository.findById((long) 1).get();
        Food food = this.foodRepository.findById((long) 1).get();
        fox.setDrink(drink);
        fox.setFood(food);
        this.foxRepository.save(fox);
    }

    @Override
    public Fox getFoxByName(String name) {
        return this.foxRepository.findByName(name);
    }

    @Override
    public Fox getFoxById(Long id) {
        return this.foxRepository.findById(id).get();
    }

    @Override
    public boolean foxExistsByName(String foxName) {
        return this.foxRepository.existsByName(foxName);
    }

    @Override
    public void updateFoodAndDrink(String foxName, String foodName, String drinkName) {
        Fox fox = getFoxByName(foxName);
        Food food = this.foodRepository.findByName(foodName);
        Drink drink = this.drinkRepository.findByName(drinkName);
        fox.setFood(food);
        fox.setDrink(drink);
        this.foxRepository.save(fox);
    }
}
