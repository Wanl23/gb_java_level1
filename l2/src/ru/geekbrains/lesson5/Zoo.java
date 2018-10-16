package ru.geekbrains.lesson5;

public class Zoo {
    public static void main(String[] args){
//        У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м., Лошадь 1500 м.,
//        Птица 5 м.,; прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ; плавание: кот и птица не умеет плавать,
//        собака 10 м., лошадь 100 м.).

        Animal[] zoo = new Animal[]{
                new Cat("cat", 200, 0, 2),
                new Cat("cat2"),
                new Cat("cat3"),
                new Dog("dog", 500, 10, 0.5f),
                new Dog("dog2"),
                new Dog("dog3"),
                new Horse("horse", 1500, 100, 3),
                new Horse("horse2"),
                new Horse("horse3"),
                new Bird("bird", 5, 0, 0.2f),
                new Bird("bird2"),
                new Bird("bird3")
        };

//        При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
//        (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')

        float runGoal = 300;
        float swimGoal = 15;
        float jumpGoal = 2;

        for(int i = 0; i < zoo.length; i++){
            System.out.println();
            System.out.println(zoo[i].getName() + " is getting ready for running " + runGoal);
            if(zoo[i].run(runGoal)) System.out.println(zoo[i].getName() + " running");
            else System.out.println("it is too difficult for " + zoo[i].getName() + ", maximum it can run " + zoo[i].getRunRestrictions());

            System.out.println();
            System.out.println(zoo[i].getName() + " is getting ready for swimming " + swimGoal);
            if(zoo[i].swim(swimGoal)) System.out.println(zoo[i].getName() + " swimming");
            else System.out.println("it is too difficult for " + zoo[i].getName() + ", maximum it can swim " + zoo[i].getSwimRestrictions());

            System.out.println();
            System.out.println(zoo[i].getName() + " is getting ready for jumping " + jumpGoal);
            if(zoo[i].jumpOver(jumpGoal)) System.out.println(zoo[i].getName() + " jumping");
            else System.out.println("it is too difficult for " + zoo[i].getName() + ", maximum it can jump " + zoo[i].getJumpRestrictions());
        }
    }
}
