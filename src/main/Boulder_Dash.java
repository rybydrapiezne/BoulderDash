package main;

import Game.Plane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boulder_Dash {
    private JButton Play;
    private JPanel main_menu;
    private JButton Exit;
    private JButton Options;
    private JLabel Name;
    JFrame frame;
    JFrame frame_play;
    Settings options;
    Board gameBoard;
    public Boulder_Dash() {
        frame=new JFrame("Boulder Dash");
         frame_play=new JFrame("Boulder Dash");


        set_main_menu();
        options=new Settings(this);
        Plane plane=new Plane(options.difficulty);
        gameBoard=new Board();

        Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            frame.setContentPane(gameBoard.board);
            frame.pack();
            frame.setVisible(true);
            }
        });
        Options.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                frame.setContentPane(options.settings);
                frame.pack();
                frame.setVisible(true);

            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container frame1 = Exit.getParent();
                do
                    frame1 = frame1.getParent();
                while (!(frame1 instanceof JFrame));
                ((JFrame) frame1).dispose();
            }
        });
    }
    public void set_main_menu()
    {
        frame.setContentPane(main_menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args)
    {
        Boulder_Dash boulder_dash=new Boulder_Dash();



    }


}
