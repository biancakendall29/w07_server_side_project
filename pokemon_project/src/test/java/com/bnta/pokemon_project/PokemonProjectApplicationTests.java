package com.bnta.pokemon_project;

import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import com.bnta.pokemon_project.repositories.TrainerRepository;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.repositories.GymRepository;
import com.bnta.pokemon_project.repositories.PokemonRepository;

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

//	Amber's DQ testing
	@Autowired
	GymRepository gymRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindPokemonsWithLevelBetween() {
		List<Pokemon> found = pokemonRepository.findByLevelBetween(50, 80);
		assertThat(found.size()).isEqualTo(3);
	}

//	Amber's DQ testing
	@Test
	public void canFindNameContainingWord(){
		List<Gym> found = gymRepository.findByNameContainingIgnoreCase("driftveil");
		assertThat(found.size()).isEqualTo(1);
	}
//	todo: need to add more gyms as there is not much to test on

	@Test
	public void canFindWaterTypeInPokemon(){
		List<Pokemon> found = pokemonRepository.findPokemonByType("water");
		assertThat(found.size()).isEqualTo(2);
	} // is an enum extra steps must be added to the main code


	@Test
	public void canFindTrainersWithNameStartingWith() {
		List<Trainer> found = trainerRepository.findByNameStartingWith("B");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindTrainersBySizeOfPokemonList() {
		Integer found = trainerRepository.countByNameContaining("a");
		assertThat(found).isEqualTo(3);
	}
}
