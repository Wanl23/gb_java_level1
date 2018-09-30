package ru.geekbrains;

public class Main {
    public static void main(String[] args){
        //        Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
        //        где a, b, c, d – целочисленные входные параметры этого метода;
        System.out.println(mathExpression(3, 2, 3,2));

        //        Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в
        //        пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        System.out.println(ifNumberBetween10and20(10, 10));

        //        Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
        //        в консольпроверить положительное ли число передали, или отрицательное. Замечание: ноль считаем
        //        положительным числом. Результат работы метода вывести в консоль
        positivOrNegative(0);
        positivOrNegative(-1);

        //        Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен
        //        вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
        helloName("Any name");

        //        *Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным,
        //        кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести
        //        результаты работы метода в консоль
        ifLeapYear(2018);
        ifLeapYear(2016);
        ifLeapYear(2000);
        ifLeapYear(1900);
    }

    public static float mathExpression(int a, int b, int c, int d){
        float result = ((float)a * ((float)b + ((float)c / (float)d)));
        return result;
    }

    public static boolean ifNumberBetween10and20(int a, int b){
        boolean result = true;
        if((a+b) > 10 && (a+b) <= 20){
            System.out.println("a + b is between 10 and 20");
            return true;
        }
        else{
            System.out.println("a + b isn't between 10 and 20");
            return false;
        }
    }

    public static void positivOrNegative(int a){
        if(a >= 0){
            System.out.println("the " + a + " is positive");
        }
        else{
            System.out.println("the " + a + " is negative");
        }
    }

    public static String helloName(String name){
        String helloMessage = "Привет "+ name + "!";
        System.out.println(helloMessage);
        return helloMessage;
    }

    public static void ifLeapYear(int year){
        if((year % 4) == 0){
            if((year % 100) == 0){
                if ((year % 400) ==0){
                    System.out.println(year + " год високосный");
                }
                else {
                    System.out.println(year + " год не високосный");
                }
            }
            else{
                System.out.println(year + " год високосный");
            }
        }
        else{
            System.out.println(year + " год не високосный");
        }
    }


}
