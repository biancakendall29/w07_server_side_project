package com.bnta.pokemon_project.components;

import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.GymLeaderRepository;
import com.bnta.pokemon_project.repositories.GymRepository;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import com.bnta.pokemon_project.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired // Dependency Injection
    GymLeaderRepository gymLeaderRepository;

    @Autowired
    GymRepository gymRepository;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Injecting Trainers into Trainer Repo
        Trainer trainer1 = new Trainer("Barry", LocalDate.of(2000,01,01));
        Trainer trainer2 = new Trainer("Lucas", LocalDate.of(1998,05,06));
        Trainer trainer3 = new Trainer("Chase", LocalDate.of(2010,12,30));
        trainerRepository.saveAll(Arrays.asList(trainer1, trainer2, trainer3));





    }


}

