package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Battle;
import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.GymLeaderRepository;
import com.bnta.pokemon_project.repositories.GymRepository;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import com.bnta.pokemon_project.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "gyms")
public class GymController {

    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private GymLeaderRepository gymLeaderRepository;
    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Gym>> getGyms() {
        return new ResponseEntity(gymRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Gym> getGym(@PathVariable Long id) {
        var found = gymRepository.findById(id);
        return new ResponseEntity(gymRepository.findById(id), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<List<Gym>> createGym(@RequestBody Gym newGym) {
        gymRepository.save(newGym);
        return new ResponseEntity(gymRepository.findAll(), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Gym>> deleteGym(@PathVariable Long id) {
        var found = gymRepository.findById(id);
        gymRepository.deleteById(id);
        return new ResponseEntity(gymRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CHANGE: CHANGE GYM LEADER
    @PutMapping("/changeLeader/{id_gym}/{id_leader}")
    public ResponseEntity<Gym> changeLeaderInGym(@PathVariable("id_gym") Long id_gym, @PathVariable("id_leader") Long id_leader) {
        var found = gymRepository.findById(id_gym);
        Gym gymChange = found.get();
        gymChange.setGymLeader(
                gymLeaderRepository.findAll()
                         .stream()
                        .filter(pok -> pok.getId() == id_leader)
                        .findAny().get()
        );
        return new ResponseEntity(gymRepository.findById(id_gym).get(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }

    // To add a battle to the battleLog file: input /battle and provide the location of the battle in terms of a Gym id
    @PostMapping("/battle/{id}")
    // requests user to input the details of the battle: location is provided in the path call, and date is automatically
    // assigned, body must contain an array (length 2) of trainer ids taking part in battle, an array (length 2) of
    // pokemons taking part in battle, and a result (true if trainer1 wins, false if trainer2 wins)
    public ResponseEntity<Battle> createBattle(@PathVariable Long id, @RequestBody Battle newBattle) throws IOException {
        var found = gymRepository.findById(id); // find gym from id input by user in path
        Gym gymBattle = found.get(); // convert to type Gym
        newBattle.setDate(LocalDate.now()); // set date to today's date
        newBattle.setLocation(gymBattle.getName()); // set location to name of gym from provided Gym object

        // given trainer ids, find corresponding Trainer objects
        Trainer trainer1 = trainerRepository.findById(newBattle.getTrainer_ids()[0]).stream().findAny().get();
        Trainer trainer2 = trainerRepository.findById(newBattle.getTrainer_ids()[1]).stream().findAny().get();
        // create array of Trainers battling
        Trainer[] trainers = {trainer1, trainer2};
        // search for pokemons that each trainer contains in their respective collections
        List<Long> pok_ids1 = trainer1.getPokemons().stream().map(pok -> pok.getId()).collect(Collectors.toList());
        List<Long> pok_ids2 = trainer2.getPokemons().stream().map(pok -> pok.getId()).collect(Collectors.toList());

        // if trainer does not have pokemon that they are specified to battle with (in request body), return NOT FOUND,
        // and do not proceed with logging battle to file
        if ( pok_ids1.stream().filter(i -> i.equals(newBattle.getPokemon_ids()[0])).findAny().isEmpty() ) {
            return new ResponseEntity(newBattle, HttpStatus.NOT_FOUND);
        }
        else if ( pok_ids2.stream().filter(i -> i.equals(newBattle.getPokemon_ids()[1])).findAny().isEmpty() ) {
            return new ResponseEntity(newBattle, HttpStatus.NOT_FOUND);
        }
        // given pokemons ids, find corresponding Pokemon objects
        Pokemon pok1 = pokemonRepository.findById(newBattle.getPokemon_ids()[0]).stream().findAny().get();
        Pokemon pok2 = pokemonRepository.findById(newBattle.getPokemon_ids()[1]).stream().findAny().get();
        Pokemon[] poks = {pok1, pok2};

        // call addBattle method in Gym class, providing details of battle
        gymBattle.addBattle(newBattle, trainers, poks);
        // return the details of the battle as input by the user, and response CREATED
        return new ResponseEntity(newBattle, HttpStatus.CREATED);
    }

}
