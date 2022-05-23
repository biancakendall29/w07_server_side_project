package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.GymLeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymLeaderRepository extends JpaRepository <GymLeader, Long> {

    }
