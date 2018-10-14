package ru.geekbrains.lesson5;

public class Horse extends Animal{

    public Horse(String name) {
        super(name);
    }

    public Horse(String name, float runRestrictions, float swimRestrictions, float jumpRestrictions){
        super(name, runRestrictions, swimRestrictions, jumpRestrictions);
    }
}
