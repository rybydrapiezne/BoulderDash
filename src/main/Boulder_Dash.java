package main;

import Character.Player;
import Game.Empty;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Boulder_Dash {
    private JButton Play;
    private JPanel main_menu;
    private JButton Exit;
    private JButton Options;
    private JLabel Name;
    JFrame frame;
    JFrame frame_play;
    Settings options;
    Game_form gameBoard;
    public Boulder_Dash() throws FileNotFoundException {
        frame=new JFrame("Boulder Dash");
         frame_play=new JFrame("Boulder Dash");


        set_main_menu();
        options=new Settings(this);

        gameBoard=new Game_form(this);

        Play.addActionListener(e -> {
        frame.setContentPane(gameBoard.board);
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_UP)
                    {
                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y-1).get(gameBoard.plane.player_position.x).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(1);
                            gameBoard.plane.player_position.y--;
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                        }
                        frame.repaint();
                        System.out.println("Tak");
                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    {
                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y+1).get(gameBoard.plane.player_position.x).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(2);
                            gameBoard.plane.player_position.y++;
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                        }
                        frame.repaint();
                        System.out.println("Tak");
                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                    {
                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x+1).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(3);
                            gameBoard.plane.player_position.x++;
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                        }
                        frame.repaint();
                        System.out.println("Tak");
                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT)
                    {

                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x-1).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(4);
                            gameBoard.plane.player_position.x--;
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);

                        }frame.repaint();
                        System.out.println("Tak");
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        frame.pack();
        frame.setVisible(true);
        });
        Options.addActionListener(e -> {


            frame.setContentPane(options.settings);
            frame.pack();
            frame.setVisible(true);

        });
        Exit.addActionListener(e -> {
            Container frame1 = Exit.getParent();
            do
                frame1 = frame1.getParent();
            while (!(frame1 instanceof JFrame));
            ((JFrame) frame1).dispose();
        });
    }

    public void set_main_menu()
    {
        frame.setContentPane(main_menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args) throws FileNotFoundException {
        Boulder_Dash boulder_dash=new Boulder_Dash();




    }


}
