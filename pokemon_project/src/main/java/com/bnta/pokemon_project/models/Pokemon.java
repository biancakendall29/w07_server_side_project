package com.bnta.pokemon_project.models;

public class Pokemon {

    private Long id;
    private String name;
    private Type type; // enum
    private int level; // 1 - 100

    public Pokemon(String name, Type type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public Pokemon() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
