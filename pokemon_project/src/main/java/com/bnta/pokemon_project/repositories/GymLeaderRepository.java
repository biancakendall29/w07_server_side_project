package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.GymLeader;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymLeaderRepository extends JpaRepository <GymLeader, Long> {

// Naim's Code //

// Derived Queries (DQ):

    // DQ1 - Find GymLeader by Name (case-sensitive)
    List<GymLeader> findByName (String name);

    // DQ2 - Find GymLeader by Name (not case-sensitive)
    List<GymLeader> findByNameContainingIgnoreCase(String Name);


    // DQ3 - Find GymLeader by Gym
    List<GymLeader> findByGym (String gym);

    // This one is not complete in the Testing file
    // DQ4 - Find GymLeader by ID
    List<GymLeader> findByID (Long id);

    // DQ5 - Find any GymLeader whose name contains the string 'Cl' within it's name
    List<GymLeader> findByNameContaining (String string);
}
