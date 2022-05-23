package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gyms")
public class GymController {

    @Autowired
    private GymRepository gymRepository;

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
    public void createGym(@RequestBody Gym newGym) {
        gymRepository.save(newGym);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Gym>> deleteGym(@PathVariable Long id) {
        var found = gymRepository.findById(id);
        gymRepository.deleteById(id);
        return new ResponseEntity(gymRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
    }

}
