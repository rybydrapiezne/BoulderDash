package main;

import Game.Difficulty;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    private JButton applyButton;
    private JComboBox<String> settingsList;
    public JPanel settings;
    private JButton backButton;
    Difficulty difficulty;

    public Settings(Boulder_Dash boulder_dash) {
        String []level={"Easy","Medium","Hard"};
        settingsList.addItem(level[0]);
        settingsList.addItem(level[1]);
        settingsList.addItem(level[2]);
        difficulty=Difficulty.Easy;

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=settingsList.getSelectedIndex();
                difficulty=Difficulty.valueOf(settingsList.getItemAt(index));
            }
        });
        settingsList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boulder_dash.set_main_menu();

            }
        });
    }



}
