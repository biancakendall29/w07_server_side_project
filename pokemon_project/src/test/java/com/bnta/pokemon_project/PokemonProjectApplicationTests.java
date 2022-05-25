package com.bnta.pokemon_project;

import com.bnta.pokemon_project.models.*;
import com.bnta.pokemon_project.repositories.*;

import com.bnta.pokemon_project.models.Pokemon;
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
	@Autowired
	GymLeaderRepository gymLeaderRepository;
	@Autowired
	GymRepository gymRepository;

	@Test
	void contextLoads() {
	}


//	------- Pokemon DQ tests -------
//	Bianca's DQ testing
	@Test
	public void canFindPokemonsWithLevelBetween() {
		List<Pokemon> found = pokemonRepository.findByLevelBetween(50, 80);
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindPokemonWithLevelLessThan(){
		List<Pokemon> found = pokemonRepository.findByLevelLessThan(40);
		assertThat(found.size()).isEqualTo(4);
	}

	@Test
	public void canFindPokemonNameByLetter(){
		Integer found = pokemonRepository.countByNameContaining("r");
		assertThat(found).isEqualTo(6);
	}


// -------- Gym DQ tests ------
//	Amber's DQ testing
	@Test
	public void canFindNameContainingWord(){
		List<Gym> found = gymRepository.findByNameContainingIgnoreCase("driftveil");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindGymNameByLetter() {
		Integer found = gymRepository.countByNameContaining("o");
		assertThat(found).isEqualTo(4);
	}
//	todo: need to add more gyms as there is not much to test on

//	@Test
//	public void canFindWaterTypeInPokemon(){
//		List<Pokemon> found = pokemonRepository.findPokemonByType("water");
//		assertThat(found.size()).isEqualTo(2);
//	}
	// is an enum extra steps must be added to the main code


//	------ Trainer DQ tests --------
//	Bianca's DT testing
	@Test
	public void canFindTrainersWithNameStartingWith() {
		List<Trainer> found = trainerRepository.findByNameStartingWith("B");
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	public void canFindTrainersBySizeOfPokemonList() {
		Integer found = trainerRepository.countByNameContaining("a");
		assertThat(found).isEqualTo(3);
	}


// ------------ Gym Leader DQ tests -------
//	Naim's DQ testing
	@Test
	public void canFindLeaderName () {
	List<GymLeader> found = gymLeaderRepository.findByNameContainingIgnoreCase("clay");
	assertThat(found.size()).isEqualTo(1);
	}

	// NA DQ4 - FindByNameThatContains - Double Check This
	@Test
	public void canFindNameContaining (){
		List<GymLeader> found = gymLeaderRepository.findByNameContainingIgnoreCase("cl");
		assertThat(found.size()).isEqualTo(1);
	}

}
