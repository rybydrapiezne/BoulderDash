package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win_Screen {
     JPanel Win;
    private JTextArea youWonTextArea;
    private JButton exitButton;

    public Win_Screen() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boulder_Dash.boulder_dash.set_main_menu();
            }
        });
    }
}
