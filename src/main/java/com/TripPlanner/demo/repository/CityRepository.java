package com.TripPlanner.demo.repository;

import com.TripPlanner.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
