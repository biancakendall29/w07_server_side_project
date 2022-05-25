package com.bnta.pokemon_project.components;

import com.bnta.pokemon_project.models.*;
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
        Trainer trainer1 = new Trainer("Barry", LocalDate.of(2000,1,1));
        Trainer trainer2 = new Trainer("Lucas", LocalDate.of(1998,5,6));
        Trainer trainer3 = new Trainer("Chase", LocalDate.of(2010,2,30));
        Trainer trainer4 = new Trainer("Ash", LocalDate.of(1979,12,28));
        Trainer trainer5 = new Trainer("Brock", LocalDate.of(1992,10,10));
        Trainer trainer6 = new Trainer("Clemont", LocalDate.of(2009,9,13));
        trainerRepository.saveAll(Arrays.asList(trainer1, trainer2, trainer3, trainer4, trainer5, trainer6));

        // Injecting Gyms into Gyms Repo
        Gym gym1 = new Gym("Opelucid Gym", Arrays.asList(trainer1, trainer5));
        Gym gym2 = new Gym("Driftveil Gym", Arrays.asList(trainer1, trainer2, trainer3));
        Gym gym3 = new Gym("Snowpoint Gym", Arrays.asList(trainer1, trainer2, trainer4));
        Gym gym4 = new Gym("Sunnyshore Gym", Arrays.asList(trainer1, trainer2, trainer3));
        Gym gym5 = new Gym("Mossdeep Gym", Arrays.asList(trainer1, trainer4, trainer5, trainer6));
        Gym gym6 = new Gym("Striaton Gym", Arrays.asList(trainer1, trainer2, trainer3, trainer4, trainer5, trainer6));
        gymRepository.saveAll(Arrays.asList(gym1, gym2, gym3, gym4, gym5, gym6));

        // Injecting the GymLeaders into GymLeader Repo
        GymLeader gymLeader1 = new GymLeader("Iris", gym1);
        GymLeader gymLeader2 = new GymLeader("Clay", gym2);
        GymLeader gymLeader3 = new GymLeader("Bianca", gym3);
        GymLeader gymLeader4 = new GymLeader("Naim", gym4);
        GymLeader gymLeader5 = new GymLeader("Cece", gym5);
        GymLeader gymLeader6 = new GymLeader("Chris", gym6);
        gymLeaderRepository.saveAll(Arrays.asList(gymLeader1, gymLeader2, gymLeader3, gymLeader4, gymLeader5, gymLeader6));

        // Injecting the Pokémon into the Pokémon Repo
        Pokemon pokemon1 = new Pokemon("Machamp", Type.FIGHTING, 50, trainer1);
        Pokemon pokemon2 = new Pokemon("Torkoal", Type.FIRE, 10, trainer4);
        Pokemon pokemon3 = new Pokemon("Treeko", Type.GRASS, 41, trainer2);
        Pokemon pokemon4 = new Pokemon("Krabby", Type.WATER, 25, trainer3);
        Pokemon pokemon5 = new Pokemon("Squirtle", Type.WATER, 78, trainer1);
        Pokemon pokemon6 = new Pokemon("Chimchar", Type.FIRE, 97, trainer2);
        Pokemon pokemon7 = new Pokemon("Klinglang", Type.STEEL, 53, trainer5);
        Pokemon pokemon8 = new Pokemon("Alakazam", Type.PSYCHIC, 21, trainer5);
        Pokemon pokemon9 = new Pokemon("Cinccino", Type.NORMAL, 15, trainer5);
        Pokemon pokemon10 = new Pokemon("Bulbasaur", Type.GRASS, 46, trainer2);
        pokemonRepository.saveAll(Arrays.asList(pokemon1,pokemon2,pokemon3,pokemon4,pokemon5,pokemon6,pokemon7,pokemon8,pokemon9,pokemon10));
    }


}

