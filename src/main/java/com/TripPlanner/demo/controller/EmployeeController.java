package com.TripPlanner.demo.controller;


import com.TripPlanner.demo.model.City;
import com.TripPlanner.demo.model.TopAttractions;
import com.TripPlanner.demo.repository.CityRepository;
import com.TripPlanner.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City city) {
        return city.getSpots();
    }

    @PostMapping("/AddCity")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(@Valid @RequestBody City city) {
        cityRepository.deleteById(city.getId());
    }

    /*@PostMapping("/UpdateCityAttractions")
    public void updateCityAttractions(@Valid @RequestBody City city) {

    }*/
}
