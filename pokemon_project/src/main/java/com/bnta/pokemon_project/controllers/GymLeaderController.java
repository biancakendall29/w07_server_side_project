package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.GymLeader;
import com.bnta.pokemon_project.repositories.GymLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gym_leaders")
public class GymLeaderController {

    @Autowired
    private GymLeaderRepository gymLeaderRepository;

    //INDEX
    @GetMapping
    public ResponseEntity<List<GymLeader>> getGymLeader(){
        return new ResponseEntity<>(gymLeaderRepository.findAll(), HttpStatus.OK);
    }

    //SHOW
    @GetMapping("/{id}")
    public ResponseEntity<GymLeader> getGymLeader(@PathVariable Long id) {
        var found = gymLeaderRepository.findById(id);
        return new ResponseEntity(gymLeaderRepository.findById(id), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<List<GymLeader>> createGymLeader(@RequestBody GymLeader newGymLeader) {
        gymLeaderRepository.save(newGymLeader);
        return new ResponseEntity(gymLeaderRepository.findAll(), HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<List<GymLeader>> deleteGymLeader(@PathVariable Long id) {
        var found = gymLeaderRepository.findById(id);
        gymLeaderRepository.deleteById(id);
        return new ResponseEntity(gymLeaderRepository.findAll(), found.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }


}
