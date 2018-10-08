package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTac {
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    private static Scanner SCANNER = new Scanner(System.in);
    private static Random RANDOM = new Random();

    private static int fieldSizeY = 5;
    private static int fieldSizeX = 5;
    private static int winRate = 4;
    private static char[][] field;

    private static void initField(){
        field = new char[fieldSizeY][fieldSizeY];
        for(int y = 0; y < fieldSizeX; y++){
            for(int x = 0; x < fieldSizeY; x++){
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    private static void printField(){
        System.out.println(" _y_y_y_y_y");
        for(int y = 0; y < field.length; y++){
            System.out.print("x ");
            for(int x = 0; x < field.length; x++){
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn(){
        int x;
        int y;
        do{
            System.out.println("Enter coordinates X and Y(1-3) separated by space: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }while (!isEmptyCell(y, x) || !isValidCell(y, x));
        field[y][x] = HUMAN_DOT;
    }

    private static boolean isEmptyCell(int y, int x){
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isValidCell(int y, int x){
        return x >= 0 && x < fieldSizeY && y >= 0 && y <fieldSizeY;
    }

    private static void aiTurn(){
//        int counterDiag1 = 0;
//        int counterDiag2 = 0;
//        boolean moveDone = false;
//        for(int y = 0; y < field.length; y++) {
//            if(moveDone){
//                break;
//            }
//            int humanDotQtyX = 0;
//            int humanDotQtyY = 0;
//            for (int x = 0; x < field.length; x++) {
//                if(field[y][x] == HUMAN_DOT){
//                    humanDotQtyX++;
//                    if(humanDotQtyX == 2){
//                        for(int xx = 0; xx < field.length; xx++ ){
//                            if(isEmptyCell(y, xx)) {
//                                field[y][xx] = AI_DOT;
//                                moveDone = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if(field[x][y] == HUMAN_DOT){
//                    humanDotQtyY++;
//                    if(humanDotQtyY == 2){
//                        for(int xx = 0; xx < field.length; xx++ ){
//                            if(isEmptyCell(xx, y)) {
//                                field[xx][y] = AI_DOT;
//                                moveDone = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (x == y && field[y][x] == HUMAN_DOT) {
//                    counterDiag1++;
//                    if(counterDiag1 == 2){
//                        for(int i = 0; i < field.length; i++ ){
//                            if(isEmptyCell(i, i)) {
//                                field[i][i] = AI_DOT;
//                                moveDone = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (x == field.length - y - 1 && field[y][x] == HUMAN_DOT) {
//                    counterDiag2++;
//                    if(counterDiag2 == 2){
//                        for(int i = 0; i < field.length; i++ ){
//                            if(isEmptyCell(field.length - i - 1, field.length - i - 1)) {
//                                field[field.length - i - 1][field.length - i - 1] = AI_DOT;
//                                moveDone = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//            if(y == 2){
//                int i;
//                int j;
//                do {
//                    i = RANDOM.nextInt(fieldSizeX);
//                    j = RANDOM.nextInt(fieldSizeY);
//                } while (!isEmptyCell(i, j));
//                field[i][j] = AI_DOT;
//                break;
//            }
//        }
        int i;
        int j;
        do {
            i = RANDOM.nextInt(fieldSizeX);
            j = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(i, j));
        field[i][j] = AI_DOT;
    }

    private static boolean isMapFull(){
        for(int y = 0; y < fieldSizeY; y++){
            for(int x = 0; x < fieldSizeX; x++){
                if(isEmptyCell(x, y)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char dot) {
        int counterDiag1 = 0;
        int counterDiag2 = 0;
        int counterDiag3 = 0;
        int counterDiag4 = 0;
        for (int y = 0; y < field.length; y++) {
            int counterX = 0;
            int counterY = 0;
            for (int x = 0; x < field.length; x++) {
                if (field[y][x] == dot) counterX++;
                if (field[x][y] == dot) counterY++;
                if (counterX == winRate || counterY == winRate) return true;

                if ((y - x) >= 0) {
                    if (field[x][y - x] == dot) {
                        counterDiag1++;
                        if (counterDiag1 == winRate) return true;
                    }
                } else counterDiag1 = 0;

                if(x > 0) {
                    if (field[x][field.length - x] == dot) {
                        counterDiag2++;
                        if (counterDiag2 == winRate) return true;
                    }
                }
                else counterDiag2 = 0;

                if((field.length - 1 - y + x) < field.length){
                    if(field[x][field.length - 1 - y + x] == dot){
                        counterDiag3++;
                        if(counterDiag3 == winRate) return true;
                    }
                }
                else counterDiag3 = 0;

                if(y + x < field.length && y > 0){
                    if(field[x+y][x] == dot){
                        counterDiag4++;
                        if(counterDiag4 == winRate) return true;
                    }
                }
                else counterDiag4 = 0;
            }
        }
        return false;
    }

    public static void main(String[] args){
        while(true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkWin(HUMAN_DOT)) {
                    System.out.println("Player wins");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Draw");
                    break;
                }
                aiTurn();
                printField();
                if (checkWin(AI_DOT)) {
                    System.out.println("Computer wins");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Draw");
                    break;
                }
            }
            System.out.println("Do you want to play again?");
            SCANNER.nextLine();
            if(SCANNER.nextLine().equals("n")){
                break;
            }
        }
    }
}
