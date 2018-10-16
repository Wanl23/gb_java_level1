package ru.geekbrains.lesson6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
//        Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
//        Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//        * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
//        ** Написать метод, проверяющий, есть ли указанное слово в папке

    public static void main(String[] args) {
        String fileName1 = "src\\ru\\geekbrains\\lesson6\\files\\first.txt";
        String fileName2 = "src\\ru\\geekbrains\\lesson6\\files\\second.txt";
        String fileResult = "src\\ru\\geekbrains\\lesson6\\files\\third.txt";
        String filePath = "src\\ru\\geekbrains\\lesson6\\files";
        String word = "shall";

//        Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        WorkWithFiles.connectTwoFiles(fileName1, fileName2, fileResult);

//        * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        if(WorkWithFiles.findWord(fileName1, word)) System.out.println("Word was finded in file");
        else System.out.println("Word was not finded in file");

//        ** Написать метод, проверяющий, есть ли указанное слово в папке
        if(WorkWithFiles.ifWordInFolder(word, filePath)) System.out.println("Word was finded in path");
        else System.out.println("Word was not finded in path");
    }
}
