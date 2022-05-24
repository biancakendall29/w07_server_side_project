package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {
    // Amber's lines
    List<Pokemon> findPokemonByType(String type);



    //

    // Naim's lines




    //

    // Bianca's lines




    //
}
