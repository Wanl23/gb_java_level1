package ru.geekbrains.lesson5;

public class Cat extends Animal {

    private String name;
    private float runRestrictions;
    private float swimRestrictions;
    private float jumpRestrictions;

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, float runRestrictions, float swimRestrictions, float jumpRestrictions){
        super(name, runRestrictions, swimRestrictions, jumpRestrictions);
    }
}
