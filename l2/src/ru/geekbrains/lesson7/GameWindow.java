package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 700;
    public static final int WINDOW_POS_X = 150;
    public static final int WINDOW_POS_Y = 50;

    private Map map;
    private SettingsWindow settingsWindow;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);
        setResizable(false);
        setTitle("TicTacToe");

        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        JButton btnStop = new JButton("Exit");
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panBottom = new JPanel();
        panBottom.setLayout(new GridLayout(1, 2));
        panBottom.add(btnStart, BorderLayout.NORTH);
        panBottom.add(btnStop, BorderLayout.SOUTH);
        map = new Map();
        settingsWindow = new SettingsWindow(this);

        add(panBottom, BorderLayout.SOUTH);
        add(map, BorderLayout.CENTER);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
