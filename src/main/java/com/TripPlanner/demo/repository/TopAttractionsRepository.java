package com.TripPlanner.demo.repository;

import com.TripPlanner.demo.model.TopAttractions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopAttractionsRepository extends JpaRepository<TopAttractions, Long> {
    List<TopAttractions> findByCityId(Long cityId);
    //Page<TopAttractions> findByCityId(Long cityId, Pageable pageable);
    Optional<TopAttractions> findByIdAndCityId(Long id, Long cityId);
}
