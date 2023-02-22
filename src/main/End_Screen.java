package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class End_Screen {
    private JTextArea youDiedTextArea;
    private JButton exitButton;

    JPanel end_screen;



    public End_Screen(JFrame frame) {

        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Boulder_Dash.boulder_dash.set_main_menu();
            }
        });
    }
}
