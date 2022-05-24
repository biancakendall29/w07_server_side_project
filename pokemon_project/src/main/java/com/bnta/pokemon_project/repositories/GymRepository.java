package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymRepository extends JpaRepository <Gym, Long> {
//    Amber's line
//    Basic derived queries
    List<Gym> findGymByName(String name);
    List<Gym> findByNameContainingIgnoreCase(String name);

}
