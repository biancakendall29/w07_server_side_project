package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.models.Pokemon;
import com.bnta.pokemon_project.models.Trainer;
import com.bnta.pokemon_project.repositories.GymLeaderRepository;
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
    @Autowired
    private GymLeaderRepository gymLeaderRepository;

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

}
