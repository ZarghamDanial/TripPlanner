package com.TripPlanner.demo.controller;


import com.TripPlanner.demo.exceptions.ResourceNotFoundException;
import com.TripPlanner.demo.model.City;
import com.TripPlanner.demo.model.TopAttractions;
import com.TripPlanner.demo.repository.CityRepository;
import com.TripPlanner.demo.repository.EmployeeRepository;
import com.TripPlanner.demo.repository.TopAttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/cities/{cityId}/topAttractions")
    public List<TopAttractions> getAllTopAttractionsByCityId(@PathVariable (value = "cityId") Long cityId) {
        return topAttractionsRepository.findByCityId(cityId);
    }

    /*@GetMapping("/TopAttractions/{id}")
    public List<TopAttractions> getAllTopAttractionOfCity(@PathVariable(value = "id") Long id) {
        return topAttractionsRepository.findAll();
        //for (TopAttractions: )
    }*/

    @PostMapping("/AddCity")
    public void addCity(@Valid @RequestBody City city) {
        cityRepository.save(city);
    }

    /*@PostMapping("/city/{cityId}/topAttractions")
    public Optional<@Valid TopAttractions> createTopAttraction(@PathVariable (value = "cityId") Long cityId,
                                 @Valid @RequestBody TopAttractions topAttractions) {
        return cityRepository.findById(cityId).map(city -> {
            topAttractions.setCity(city);
            return topAttractionsRepository.save(topAttractions);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + cityId + " not found"));
    }*/

    @PostMapping("/AddTopAttraction")
    public void addTopAttraction(@Valid @RequestBody TopAttractions topAttraction) {
        //City city=topAttraction.getCity();
        topAttractionsRepository.save(topAttraction);
        //System.out.println("gugru");
    }

    @DeleteMapping("/cities/{cityId}/topAttractions/{topAttractionId}")
    public ResponseEntity<Object> deleteTopAttraction(@PathVariable (value = "cityId") Long cityId,
                                                      @PathVariable (value = "topAttractionId") Long topAttractionId) {
        return topAttractionsRepository.findByIdAndCityId(topAttractionId, cityId).map(topAttractions -> {
            topAttractionsRepository.delete(topAttractions);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Top Attraction not found with id " + topAttractionId + " and cityId " + cityId));
    }

    /*@PostMapping("/DeleteCity")
    public void deleteCity(@Valid @RequestBody City city) {
        //cityRepository.deleteById(city.getId());
        cityRepository.delete(city);
    }*/

    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<Object> deleteCity(@PathVariable Long cityId) {
        return cityRepository.findById(cityId).map(city -> {
            cityRepository.delete(city);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("CityId " + cityId + " not found"));
    }

    /*@PostMapping("/UpdateCityAttractions")
    public void updateCityAttractions(@Valid @RequestBody City city) {

    }*/
}
