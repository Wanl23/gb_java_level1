package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_HUM_HUM = 0;
    public static final int MODE_AI_HUM = 1;

    private JPanel fieldPanal;
    private JButton[][] fieldArr;

    Map(){
        setBackground(Color.CYAN);
        fieldPanal = new JPanel();
        fieldPanal.setVisible(false);
        this.add(fieldPanal);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.printf("M: %d, FSX: %d, FSY: %d, WL: %d",
                mode, fieldSizeX, fieldSizeY, winLength);
        System.out.println();

        initField(fieldSizeX, fieldSizeY);
    }

    private void initField(int fieldSizeX, int fieldSizeY) {
        fieldArr = new JButton[fieldSizeX][fieldSizeY];
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                fieldArr[i][j] = new JButton("");
                fieldArr[i][j].setPreferredSize(new Dimension(60, 60));
            }
        }

        fieldPanal.setLayout(new GridLayout(fieldSizeX, fieldSizeY));
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                fieldPanal.add(fieldArr[i][j]);
            }
        }
        fieldPanal.setVisible(true);
    }
}
