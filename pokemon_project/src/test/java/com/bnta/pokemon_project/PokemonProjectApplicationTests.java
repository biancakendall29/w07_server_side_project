package com.bnta.pokemon_project;

import com.bnta.pokemon_project.models.GymLeader;
import com.bnta.pokemon_project.repositories.GymLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PokemonProjectApplicationTests {

@Autowired
GymLeaderRepository gymLeaderRepository;

	@Test
	void contextLoads() {
	}

	// Naim's Derived Queries Tests

	// DQ 1 & 2 Test - FindByName (Case & Non-Case Sensitive - only tests non-sensitive query)
	@Test
	public void canFindNameContainingWord () {
		List<GymLeader> found = gymLeaderRepository.findByNameContainingIgnoreCase("clay");
		assertThat(found.size()).isEqualTo(1);
	}

	// DQ 3 - FindByGym
	@Test
	public void canFindByGym () {
		List<GymLeader> found = gymLeaderRepository.findByGym("Opelucid");
		assertThat(found.size()).isEqualTo(1);
	}

	// DQ4 - Need to research more on this
/*
	@Test
	public void canFindByID () {
		List<GymLeader> found = gymLeaderRepository.findById(""); // Pass something through brackets
		assertThat(found.size()).isEqualTo(1);
	}
*/

	// DQ5
	@Test
	public void canFindNameContaining (){
		List<GymLeader> found = gymLeaderRepository.findByNameContainingIgnoreCase("cl");
		assertThat(found.size()).isEqualTo(1);
	}

}
