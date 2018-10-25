package ru.geekbrains.lesson5;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public Dog(String name, float runRestrictions, float swimRestrictions, float jumpRestrictions){
        super(name, runRestrictions, swimRestrictions, jumpRestrictions);
    }
}
