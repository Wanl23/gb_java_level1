package ru.geekbrains.lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    public static final int WINDOW_WIDTH = 350;
    public static final int WINDOW_HEIGHT = 230;
    public static final int MIN_WIN_LENGTH = 3;
    public static final int MIN_FIELD_SIZE = 3;
    public static final int MAX_FIELD_SIZE = 10;
    public static final String FIELD_SIZE_PREFIX = "Field size is: ";
    public static final String WIN_LENGTH_PREFIX = "Win length is: ";

    private GameWindow gameWindow;
    private JRadioButton humVsAi;
    private JRadioButton humVsHum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2);
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));

        add(new JLabel("Choose game mode"));
        humVsAi = new JRadioButton("Human vs AI");
        humVsHum = new JRadioButton("Human vs Human");

        addGameModeControls();

        addFieldControls();

        JButton btnStart = new JButton("Apply settings");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applySettings();
            }
        });
        add(btnStart);
    }

    private void addFieldControls() {
        JLabel lblFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lblWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lblFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });

        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        add(new JLabel("Choose field size:"));
        add(lblFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length:"));
        add(lblWinLength);
        add(slideWinLen);
    }

    private void addGameModeControls() {
        ButtonGroup gameMode = new ButtonGroup();
        humVsAi.setSelected(true);
        gameMode.add(humVsAi);
        gameMode.add(humVsHum);

        add(humVsAi);
        add(humVsHum);
    }

    void applySettings(){
        int mode;
        if(humVsAi.isSelected()){
            mode = Map.MODE_AI_HUM;
        }
        else if(humVsHum.isSelected()){
            mode = Map.MODE_HUM_HUM;
        }
        else
            throw new RuntimeException("Unexpected game mode");

        int fieldSize = slideFieldSize.getValue();
        int winLen = slideWinLen.getValue();

        gameWindow.startNewGame(mode, fieldSize, fieldSize, winLen);
        setVisible(false);
    }
}
