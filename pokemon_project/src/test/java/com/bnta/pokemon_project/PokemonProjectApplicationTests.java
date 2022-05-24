package com.bnta.pokemon_project;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.repositories.GymRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PokemonProjectApplicationTests {

//	Amber's DQ testing
	@Autowired
	GymRepository gymRepository;

	@Test
	void contextLoads() {
	}

//	Amber's DQ testing
	@Test
	public void canFindNameContainingWord(){
		List<Gym> found = gymRepository.findByNameContainingIgnoreCase("driftveil");
		assertThat(found.size()).isEqualTo(1);
	}
//	todo: need to add more gyms as there is not much to test on

	@Test


}
