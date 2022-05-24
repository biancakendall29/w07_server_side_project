package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {
    // Amber's lines




    //

    // Naim's lines




    //

    // Bianca's lines

    List<Pokemon> findByLevelBetween(Integer startLevel, Integer endLevel);


    //
}
