package com.TripPlanner.demo.controller;

import com.TripPlanner.demo.model.City;
import com.TripPlanner.demo.model.TopAttractions;
import com.TripPlanner.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City) {

    }

    @PostMapping("/cities")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }
    public deleteCity()
    public updateCity()
}
