package com.TripPlanner.demo.repository;

import com.TripPlanner.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
