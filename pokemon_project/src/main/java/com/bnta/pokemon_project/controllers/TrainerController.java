package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.GymRepository;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import com.bnta.pokemon_project.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainers")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepository;
    @Autowired
    private PokemonRepository pokemonRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Trainer>> getTrainer() {
        return new ResponseEntity(trainerRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable Long id) {
        var found = trainerRepository.findById(id);
        return new ResponseEntity(trainerRepository.findById(id), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<List<Trainer>> createTrainer(@RequestBody Trainer newTrainer) {
        trainerRepository.save(newTrainer);
        return new ResponseEntity(trainerRepository.findAll(), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Trainer>> deleteTrainer(@PathVariable Long id) {
        var found = trainerRepository.findById(id);
        trainerRepository.deleteById(id);
        return new ResponseEntity(trainerRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CHANGE
    @PutMapping("/change/{id}")
    public Trainer changePokemonInTrainer(@PathVariable Long id) {
        var found = trainerRepository.findById(id);
        Trainer trainerChange = found.get();
        trainerChange.removePokemon(
                pokemonRepository.findAll()
                        .stream()
                        .
                )

    }
}
