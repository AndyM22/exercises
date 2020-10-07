package com.greenfox.spacetransporter.Controller;

import com.greenfox.spacetransporter.Model.Planet;
import com.greenfox.spacetransporter.Model.Spaceship;
import com.greenfox.spacetransporter.Service.PlanetService;
import com.greenfox.spacetransporter.Service.SpaceshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpaceshipController {

    private SpaceshipService spaceshipService;
    private PlanetService planetService;

    @Autowired
    public SpaceshipController(SpaceshipService spaceshipService, PlanetService planetService) {
        this.spaceshipService = spaceshipService;
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        Spaceship spaceship = this.spaceshipService.getSpaceshipById(1);
        model.addAttribute("planets", this.planetService.getAllPlanets());
        model.addAttribute("spaceship", spaceship);
        model.addAttribute("spaceshipLocation", this.planetService.getPlanetById(spaceship.getPlanet().getId()));
        return "index";
    }

    @PostMapping("/movehere/{id}")
    public String moveShip(@PathVariable long id, Model model) {
        Planet planet = this.planetService.getPlanetById(id);
        Spaceship spaceship = this.spaceshipService.getSpaceshipById(1);
        /*model.addAttribute("spaceship", spaceship);
        model.addAttribute("planet", planet);*/
        spaceship.setPlanet(planet);
        this.spaceshipService.updateSpaceship(spaceship);
        return "redirect:/";
    }

    @GetMapping("/toship/{id}")
    public String getPeopleToShip(@PathVariable long id, Model model) {
        Planet planet = this.planetService.getPlanetById(id);
        Spaceship spaceship = this.spaceshipService.getSpaceshipById(1);
        model.addAttribute("spaceship", spaceship);
        model.addAttribute("planet", planet);
        this.spaceshipService.embarkPeople(planet, spaceship);
        return "redirect:/";
    }

    @GetMapping("/toplanet/{id}")
    public String getPeopleToPlanet(@PathVariable long id, Model model) {
        Planet planet = this.planetService.getPlanetById(id);
        Spaceship spaceship = this.spaceshipService.getSpaceshipById(1);
        model.addAttribute("spaceship", spaceship);
        model.addAttribute("planet", planet);
        this.spaceshipService.disembarkPeople(planet, spaceship);
        return "redirect:/";
    }

}
