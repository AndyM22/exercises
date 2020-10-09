package com.greenfox.gfclub.Controller;

import com.greenfox.gfclub.Model.Drink;
import com.greenfox.gfclub.Model.Food;
import com.greenfox.gfclub.Model.Fox;
import com.greenfox.gfclub.Service.DrinkService;
import com.greenfox.gfclub.Service.FoodService;
import com.greenfox.gfclub.Service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private FoxService foxService;
    private FoodService foodService;
    private DrinkService drinkService;

    @Autowired
    public MainController(FoxService foxService, FoodService foodService, DrinkService drinkService) {
        this.foxService = foxService;
        this.foodService = foodService;
        this.drinkService = drinkService;
    }

    @GetMapping("/")
    public String mainPage(Model model, @RequestParam (required = false) String name) {
        Fox fox = this.foxService.getFoxByName(name);
        if (fox != null && name != null) {
            model.addAttribute("foxName", fox.getName());
            model.addAttribute("food", fox.getFood().getName());
            model.addAttribute("drink", fox.getDrink().getName());
            model.addAttribute("tricks", fox.getTricks().size());
            model.addAttribute("knownTricks", fox.getTricks());
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String submitLoginForm(String foxName) {
        if (this.foxService.foxExistsByName(foxName)) {
            return "redirect:/login?errorFoxExists";
        } else {
            this.foxService.addFoxByName(foxName);
            return "redirect:/?name=" + foxName;
        }
    }

    @GetMapping("/nutritionStore")
    public String nutritionStoreForm (Model model, @RequestParam String name) {
        Fox fox = this.foxService.getFoxByName(name);
        model.addAttribute("foxName", name);
        model.addAttribute("food", this.foodService.getAllFoodNAmes());
        model.addAttribute("drink", this.drinkService.getAllDrinksName());
        return "nutritionStore";
    }

    @PostMapping("/nutritionStore")
    public String submitNutritionForm(@RequestParam String name, String food, String drink) {
        this.foxService.updateFoodAndDrink(name, food, drink);
        return "redirect:/?name=" + name;
    }

}
