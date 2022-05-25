package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TrainerRepository extends JpaRepository <Trainer, Long> {
    // Amber's lines
    boolean existsByName(String Name);

    //

    // Naim's lines




    //

    // Bianca's lines

    List<Trainer> findByNameStartingWith(String prefix);

    Integer countByNameContaining(String letter);

    //
}
