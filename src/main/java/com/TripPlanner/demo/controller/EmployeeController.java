package com.TripPlanner.demo.controller;


import com.TripPlanner.demo.model.City;
import com.TripPlanner.demo.model.TopAttractions;
import com.TripPlanner.demo.repository.CityRepository;
import com.TripPlanner.demo.repository.EmployeeRepository;
import com.TripPlanner.demo.repository.TopAttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/dev")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TopAttractionsRepository topAttractionsRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/attractions")
    public List<TopAttractions> getAllTopAttractions() {
        return topAttractionsRepository.findAll();
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City city) {
        return city.getSpots();
    }

    @PostMapping("/AddCity")
    public void addCity(@Valid @RequestBody City city) {
        cityRepository.save(city);
    }

    @PostMapping("/AddTopAttraction")
    public void addTopAttraction(@Valid @RequestBody TopAttractions topAttraction) {
        //City city=topAttraction.getCity();
        topAttractionsRepository.save(topAttraction);
        System.out.println("gugru");
    }

    @PostMapping("/DeleteCity")
    public void deleteCity(@Valid @RequestBody City city) {
        //cityRepository.deleteById(city.getId());
        cityRepository.delete(city);
    }

    /*@PostMapping("/UpdateCityAttractions")
    public void updateCityAttractions(@Valid @RequestBody City city) {

    }*/
}
