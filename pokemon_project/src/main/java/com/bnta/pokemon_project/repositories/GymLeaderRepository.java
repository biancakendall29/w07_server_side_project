package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.GymLeader;

import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GymLeaderRepository extends JpaRepository <GymLeader, Long> {


// Naim's Code //

// Derived Queries (DQ):

    // Naim's DQ
    // NA DQ1 - Find GymLeader by Name (case-sensitive)
    List<GymLeader> findByName (String name);

    // NA DQ2 - Find GymLeader by Name (not case-sensitive)
    List<GymLeader> findByNameContainingIgnoreCase(String Name);


    // NA DQ3 - Find GymLeader by Gym
    List<GymLeader> findByGym (String gym);

    // NA DQ4 - Find any GymLeader whose name contains the string 'Cl' within it's name
    List<GymLeader> findByNameContaining (String string);
    // Double Check This


}
