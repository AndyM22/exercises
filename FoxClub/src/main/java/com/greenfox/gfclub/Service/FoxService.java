package com.greenfox.gfclub.Service;

import com.greenfox.gfclub.Model.Fox;

public interface FoxService {

    void addFox(Fox fox);

    void addFoxByName(String foxName);

    Fox getFoxByName(String name);

    Fox getFoxById(Long id);

    boolean foxExistsByName(String foxName);

    void updateFoodAndDrink (String foxName, String foodName, String drinkName);

}
