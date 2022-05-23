package com.bnta.pokemon_project.repositories;

import com.bnta.pokemon_project.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository <Pokemon, Long> {




}
