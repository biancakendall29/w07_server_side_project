package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {
    // Amber's lines
    List<Pokemon> findPokemonByType(String type);

//    To express the inequality
    List<Pokemon> findByNameNot(String name);


    //

    // Naim's lines




    //

    // Bianca's lines

    // in between and including the given range
    List<Pokemon> findByLevelBetween(Integer startLevel, Integer endLevel);



    //
}
