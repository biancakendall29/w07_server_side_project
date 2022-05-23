package com.bnta.pokemon_project.controllers;

import com.bnta.pokemon_project.models.Gym;
import com.bnta.pokemon_project.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
