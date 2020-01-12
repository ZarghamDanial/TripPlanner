package com.TripPlanner.demo.controller;

import com.TripPlanner.demo.model.City;
import com.TripPlanner.demo.model.TopAttractions;
import com.TripPlanner.demo.repository.CityRepository;
import com.TripPlanner.demo.repository.TopAttractionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.TripPlanner.demo.controller.TSP.TSPUtil;

@RestController
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TopAttractionsRepository topAttractionsRepository;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/PlanIt")
    public List<TopAttractions> getShortestPath(List<TopAttractions> topAttractionsList) {
        TSP tsp = new TSP();
        Double[][] cityGraph=null;
        //TopAttractions topAttractions1;
        //TopAttractions topAttractions2;
        for(TopAttractions topAttractions1: topAttractionsList) {
            for(TopAttractions topAttractions2: topAttractionsList) {
                Double latitude1 = topAttractions1.getLatitude();
                Double longitude1 = topAttractions1.getLongitude();
                Double latitude2 = topAttractions2.getLatitude();
                Double longitude2 = topAttractions2.getLongitude();

                Double crowFlyDistance=getCrowFlyDistance(latitude1, latitude2, longitude1, longitude2);
                cityGraph[Math.toIntExact(topAttractions1.getId())][Math.toIntExact(topAttractions2.getId())]=crowFlyDistance;
            }
        }
        return TSPUtil(cityGraph, topAttractionsList.size());
    }

    private Double getCrowFlyDistance(Double lat1, Double lat2, Double lon1, Double lon2) {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    @GetMapping("/TopAttractions")
    public List<TopAttractions> getAllTopAttraction(City city) {
        return city.getSpots();
    }

    @PostMapping("/AddCity")
    public City addCity(@Valid @RequestBody City city) {
        return cityRepository.save(city);
    }
}
