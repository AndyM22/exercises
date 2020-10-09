package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Food;
import com.greenfox.gfclub.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService{

    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food getFoodByName(String name) {
        return this.foodRepository.findByName(name);
    }

    @Override
    public Food getFoodById(Long id) {
        return this.foodRepository.findById(id).get();
    }

    @Override
    public List<Food> getAllFood() {
        return this.foodRepository.findAll();
    }

    @Override
    public List<String> getAllFoodNAmes() {
        return getAllFood().stream()
                .map(Food::getName)
                .collect(Collectors.toList());
    }
}
