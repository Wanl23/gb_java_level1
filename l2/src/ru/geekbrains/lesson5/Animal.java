package ru.geekbrains.lesson5;

//        Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
//
//        Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//        В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
//        или высоту (для прыжков).
//
//        У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м.,
//        Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать,
//        собака 10 м., лошадь 100 м.).
//
//        При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
//        (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
//
//        Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
//        на бег может быть 400 м., у другой 600 м.

public abstract class Animal {

    private String name;
    private float runRestrictions;
    private float swimRestrictions;
    private float jumpRestrictions;

//        Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
//        на бег может быть 400 м., у другой 600 м.
    public Animal(String name){
        this.name = name;
        if(this instanceof Cat){
            this.runRestrictions = (int)(Math.random() * ((240 - 180) + 1)) + 180;
            this.swimRestrictions = 0;
            this.jumpRestrictions = (int)(Math.random() * ((10 - 0.1f) + 1)) + 0.1f;
        }
        if(this instanceof Dog){
            this.runRestrictions = (int)(Math.random() * ((600 - 450) + 1)) + 450;
            this.swimRestrictions = (int)(Math.random() * ((12 - 9) + 1)) + 9;
            this.jumpRestrictions = (int)(Math.random() * ((1 - 0.3f) + 1)) + 0.3f;
        }
        if(this instanceof Horse){
            this.runRestrictions = (int)(Math.random() * ((1700 - 1400) + 1)) + 100;
            this.swimRestrictions = (int)(Math.random() * ((120 - 90) + 1)) + 90;
            this.jumpRestrictions = (int)(Math.random() * ((5 - 2.0f) + 1)) + 2.0f;
        }
        if(this instanceof Bird){
            this.runRestrictions = (int)(Math.random() * ((7 - 4) + 1)) + 400;
            this.swimRestrictions = 0;
            this.jumpRestrictions = (int)(Math.random() * ((1.0f - 0.1f) + 1)) + 0.1f;
        }
    }

    public Animal(String name, float runRestrictions, float swimRestrictions, float jumpRestrictions){
        this.name = name;
        this.runRestrictions = runRestrictions;
        this.swimRestrictions = swimRestrictions;
        this.jumpRestrictions = jumpRestrictions;
    }


    public boolean run(float distance){
        return (distance <= this.runRestrictions)? true : false;
    }
    public boolean swim(float distance){
        return (distance <= this.swimRestrictions)? true : false;
    }
    public boolean jumpOver(float height){
        return (height <= this.jumpRestrictions)? true : false;
    }

    public String getName() {
        return name;
    }

    public float getRunRestrictions() {
        return runRestrictions;
    }

    public float getSwimRestrictions() {
        return swimRestrictions;
    }

    public float getJumpRestrictions() {
        return jumpRestrictions;
    }
}
