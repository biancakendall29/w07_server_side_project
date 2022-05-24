package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.models.Type;
import com.bnta.pokemon_project.repositories.GymRepository;
import com.bnta.pokemon_project.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemons")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Pokemon>> getPokemons() {
        return new ResponseEntity(pokemonRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@PathVariable Long id) {
        var found = pokemonRepository.findById(id);
        return new ResponseEntity(pokemonRepository.findById(id), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<List<Pokemon>> createPokemon(@RequestBody Pokemon newPokemon) {
        pokemonRepository.save(newPokemon);
        return new ResponseEntity(pokemonRepository.findAll(), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Pokemon>> deletePokemon(@PathVariable Long id) {
        var found = pokemonRepository.findById(id);
        pokemonRepository.deleteById(id);
        return new ResponseEntity(pokemonRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CHANGE: CHANGE LEVEL
    @PutMapping("/changeLevel/{id}/{level}")
    public ResponseEntity<Pokemon> changeLevelinPokemon(@PathVariable("id") Long id, @PathVariable("level") int level) {
        var found = pokemonRepository.findById(id);
        Pokemon pokemonChange = found.get();
        pokemonChange.setLevel(level);
        return new ResponseEntity(pokemonRepository.findById(id).get(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.ACCEPTED);
    }

    // CHANGE: ADD ADDITIONAL TYPES
    //TODO: need to change type property in pokemon class to be a list
    @PutMapping("/addType/{id}/{type}")
    public ResponseEntity<Pokemon> addTypeToPokemon(@PathVariable("id") Long id, @PathVariable("type") Type type) {
        var found = pokemonRepository.findById(id);
        Pokemon pokemonChange = found.get();
        pokemonChange.addType(type);
        return new ResponseEntity(pokemonRepository.findById(id).get(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

}
