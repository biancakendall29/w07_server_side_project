package com.bnta.pokemon_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "gym_leaders")
public class GymLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "gym_id")
    private Gym gym;

    //    CONSTRUCTORS
    public GymLeader(String name, Gym gym) {
        this.name = name;
        this.gym = gym;
    }

    public GymLeader () {}

//    GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "GymLeader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gym=" + gym +
                '}';
    }
}
