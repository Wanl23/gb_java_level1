package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Main {
//1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
// [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    public static int[] chenging01(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = (array[i] == 0)? 1 : 0;
        }
        return array;
    }
//2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит
// его значениями 1 4 7 10 13 16 19 22;
    public static int[] createArr(){
        int[] array = new int[8];
        for(int i = 0, j = 1; i < 8; i ++, j+=3){
            array[i]= j;
        }
        return array;
    }

//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив
// и умножающий числа меньше 6 на 2;
    public static int[] modifierForArrayes(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] *= (array[i] < 6)? 2 : 1;
        }
        return array;
    }

//4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
    public static void minMaxInArray(int[] array){
        int max = array[0];
        int min = array[0];
        for(int i = 0; i < array.length; i++){
            max = (array[i] > max)? array[i] : max;
            min = (array[i] < min)? array[i] : min;
        }
        System.out.printf("minimum = %d, maximum = %d", min, max);
        System.out.println();
    }

//5 * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// заполнить его диагональные элементы единицами, используя цикл(ы);
    public static void createSquareArray(int size){
        int[][] sqrArray = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                sqrArray[i][j] = (i == j || j == (size - i - 1))? 1 : (int)(Math.random()*100);
                System.out.printf("%4d", sqrArray[i][j]);
            }
            System.out.println();
        }
    }

//6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
// вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
// checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance
// ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
    public static boolean checkbalance(int[] array){
        int leftSum = 0;
        for(int i = 0; i < array.length; i++){
            leftSum += array[i];
            int rightSum = 0;
            for (int j = 0; j < array.length; j++){
                rightSum += (j > i)? array[j] : 0;
            }
            if(leftSum == rightSum){
                return true;
            }
        }
        return false;
    }

//7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным,
// или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
    //!!!!!Не придумал как сделать с вспомогательным массивом!!!!!!

//8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
public static int[] shiftArray(int[] array, int n) {
    int length = array.length;
    if(n < 0) {
        for (int i = 0; i < (n * -1); i++) {
            int temp = array[0];
            for (int j = 0; j < length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[length-1] = temp;
        }
    }
    else{
        for(int i = 0; i < n; i++){
            int temp = array[length - 1];
            for(int j = length-1; j > 0; j--){
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
    }
    return array;
}

    public static void main(String[] args){
        //1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
        // [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
        int[] array01 = {1, 1, 1, 0, 0, 0, 1, 0, 1, 0};
        System.out.println(Arrays.toString(chenging01(array01)));

        //2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит
        // его значениями 1 4 7 10 13 16 19 22;
        System.out.println(Arrays.toString(createArr()));

        //3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив
        // и умножающий числа меньше 6 на 2;
        int[] arrayNumbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(modifierForArrayes(arrayNumbers)));

        //4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
        int[] minMaxArray = {6, 6, 8, 12, 45, 100, 145, 220, 6, 8, 99, 3, 7};
        minMaxInArray(minMaxArray);

        //5 * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // заполнить его диагональные элементы единицами, используя цикл(ы);
        createSquareArray(5);

        //6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен
        // вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
        // checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance
        // ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
        int[] forCheckBalanceArray = {1, 2, 3, 1, 2, 3};
        System.out.println(checkbalance(forCheckBalanceArray));

        //7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным,
        // или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
        //!!!!!Не смог сделать с вспомогательным массивом!!!!!!

        //8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
        int[] shiftArray = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(shiftArray(shiftArray, 2)));
    }
}
