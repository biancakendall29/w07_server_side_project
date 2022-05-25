package com.bnta.pokemon_project.models;

import java.time.LocalDate;

public class Battle {

    private Long id;
    private Gym location;
    private LocalDate date;
    private Trainer trainer1; // trainer1 wins = 1
    private Trainer trainer2; // trainer2 wine = 0
    private boolean result;

    public Battle(Gym location, LocalDate date, Trainer trainer1, Trainer trainer2, boolean result) {
        this.location = location;
        this.date = date;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.result = result;
    }

    public Battle() {}

    public Long getId() {
        return id;
    }

    public Gym getLocation() {
        return location;
    }

    public void setLocation(Gym location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Trainer getTrainer1() {
        return trainer1;
    }

    public void setTrainer1(Trainer trainer1) {
        this.trainer1 = trainer1;
    }

    public Trainer getTrainer2() {
        return trainer2;
    }

    public void setTrainer2(Trainer trainer2) {
        this.trainer2 = trainer2;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "id=" + id +
                ", location=" + location +
                ", date=" + date +
                ", trainer1=" + trainer1 +
                ", trainer2=" + trainer2 +
                ", result=" + result +
                '}';
    }
}
