package com.bnta.pokemon_project;

import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import com.bnta.pokemon_project.repositories.TrainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PokemonProjectApplicationTests {

	@Autowired
	PokemonRepository pokemonRepository;
	@Autowired
	TrainerRepository trainerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindPokemonsWithLevelBetween() {
		List<Pokemon> found = pokemonRepository.findByLevelBetween(50, 80);
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindTrainersWithNameStartingWith() {
		List<Trainer> found = trainerRepository.findByNameStartingWith("B");
		assertThat(found.size()).isEqualTo(1);
	}

//	@Test
//	public void canFindTrainersBySizeOfPokemonList() {
//		List<Trainer> found = trainerRepository.findBySizeOfPokemonsArrayGreaterThan(3);
//		assertThat(found.size()).isEqualTo(1);
//	}
}
