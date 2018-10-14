package ru.geekbrains.lesson5;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    public Bird(String name, float runRestrictions, float swimRestrictions, float jumpRestrictions){
        super(name, runRestrictions, swimRestrictions, jumpRestrictions);
    }
}
