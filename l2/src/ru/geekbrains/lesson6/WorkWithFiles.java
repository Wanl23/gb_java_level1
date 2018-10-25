package ru.geekbrains.lesson6;

import java.io.*;
import java.util.Scanner;

public class WorkWithFiles {

//Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    public static void connectTwoFiles(String fileName1, String fileName2, String fileResult){
        PrintStream printStream;
        try {
            printStream = new PrintStream(new FileOutputStream(fileResult));
            Scanner scanner = new Scanner(new FileInputStream(fileName1));
            while(scanner.hasNext()){
                printStream.println(scanner.nextLine());
            }
            scanner = new Scanner(new FileInputStream(fileName2));
            while(scanner.hasNext()){
                printStream.println(scanner.nextLine());
            }
            printStream.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
    public static boolean findWord(String fileName, String word){
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while(scanner.hasNext()){
                if(scanner.next().equals(word))
                    return true;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

//** Написать метод, проверяющий, есть ли указанное слово в папке
    public static boolean ifWordInFolder(String word, String path) {
        File[] folderFiles = new File(path).listFiles();
        for (int i = 0; i < folderFiles.length; i++) {
            try {
                Scanner scanner = new Scanner(new FileInputStream(folderFiles[i]));
                while (scanner.hasNext()) {
                    if (scanner.next().equals(word))
                        return true;
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
