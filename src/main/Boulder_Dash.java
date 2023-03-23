package main;

import Character.Player;
import Game.Door;
import Game.Empty;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Boulder_Dash {
    static Boulder_Dash boulder_dash;
    private JButton Play;
    public JPanel main_menu;
    private JButton Exit;
    private JButton Options;
    private JLabel Name;
    JFrame frame;
    JFrame frame_play;
    Settings options;
    Game_form gameBoard;
    boolean flag=false;
    Door door;

    public Boulder_Dash() throws FileNotFoundException {
        frame=new JFrame("Boulder Dash");
        frame_play=new JFrame("Boulder Dash");


        set_main_menu();
        options=new Settings(this);



        Play.addActionListener(e -> {
            try {
                gameBoard=new Game_form(boulder_dash,frame);

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            gameBoard.current_point_score=0;
            frame.setContentPane(gameBoard.board);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(dim.width/2-frame.getSize().width/2, (dim.height-400)/2-frame.getSize().height/2);

            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyReleased(KeyEvent e) {

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
                            for(int i=0;i<gameBoard.plane.points.size();i++)
                            {
                                if(gameBoard.plane.player_position.y==gameBoard.plane.points.get(i).get_position().y&&gameBoard.plane.player_position.x==gameBoard.plane.points.get(i).get_position().x)
                                {
                                    Game.Point point=gameBoard.plane.points.get(i);
                                    gameBoard.current_point_score++;
                                    gameBoard.plane.points.remove(point);


                                }
                            }

                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                            if(door!=null) {
                                if (gameBoard.plane.player_position.y == door.get_position().y && gameBoard.plane.player_position.x == door.get_position().x) {
                                    frame.setContentPane(new Win_Screen().Win);
                                    frame.pack();
                                    frame.setVisible(true);
                                }
                            }
                        }

                        frame.repaint();

                    }
                    if(e.getKeyCode()==KeyEvent.VK_DOWN)
                    {
                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y+1).get(gameBoard.plane.player_position.x).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(2);
                            gameBoard.plane.player_position.y++;
                            for(int i=0;i<gameBoard.plane.points.size();i++)
                            {
                                if(gameBoard.plane.player_position.y==gameBoard.plane.points.get(i).get_position().y&&gameBoard.plane.player_position.x==gameBoard.plane.points.get(i).get_position().x)
                                {
                                    Game.Point point=gameBoard.plane.points.get(i);
                                    gameBoard.current_point_score++;
                                    gameBoard.plane.points.remove(point);


                                }
                            }
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                            if(door!=null) {
                                if (gameBoard.plane.player_position.y == door.get_position().y && gameBoard.plane.player_position.x == door.get_position().x) {
                                    frame.setContentPane(new Win_Screen().Win);
                                    frame.pack();
                                    frame.setVisible(true);
                                }
                            }
                        }
                        end();
                        frame.repaint();

                    }
                    if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                    {
                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x+1).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(3);
                            gameBoard.plane.player_position.x++;
                            for(int i=0;i<gameBoard.plane.points.size();i++)
                            {
                                if(gameBoard.plane.player_position.y==gameBoard.plane.points.get(i).get_position().y&&gameBoard.plane.player_position.x==gameBoard.plane.points.get(i).get_position().x)
                                {
                                    Game.Point point=gameBoard.plane.points.get(i);
                                    gameBoard.current_point_score++;
                                    gameBoard.plane.points.remove(point);



                                }
                            }
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                            if(door!=null) {
                                if (gameBoard.plane.player_position.y == door.get_position().y && gameBoard.plane.player_position.x == door.get_position().x) {
                                    frame.setContentPane(new Win_Screen().Win);
                                    frame.pack();
                                    frame.setVisible(true);
                                }
                            }
                        }
                        end();
                        frame.repaint();

                    }
                    if(e.getKeyCode()==KeyEvent.VK_LEFT)
                    {

                        Player player=(Player)gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x);
                        if(!gameBoard.plane.board.get(gameBoard.plane.player_position.y).get(gameBoard.plane.player_position.x-1).is_collision()) {
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, new Empty());
                            player.move(4);
                            gameBoard.plane.player_position.x--;
                            for(int i=0;i<gameBoard.plane.points.size();i++)
                            {
                                if(gameBoard.plane.player_position.y==gameBoard.plane.points.get(i).get_position().y&&gameBoard.plane.player_position.x==gameBoard.plane.points.get(i).get_position().x)
                                {
                                    Game.Point point=gameBoard.plane.points.get(i);
                                    gameBoard.current_point_score++;
                                    gameBoard.plane.points.remove(point);


                                }
                            }
                            gameBoard.plane.board.get(gameBoard.plane.player_position.y).set(gameBoard.plane.player_position.x, player);
                            if(door!=null) {
                                if (gameBoard.plane.player_position.y == door.get_position().y && gameBoard.plane.player_position.x == door.get_position().x) {
                                    frame.setContentPane(new Win_Screen().Win);
                                    frame.pack();
                                    frame.setVisible(true);
                                }
                            }

                        }
                        end();
                        frame.repaint();

                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {

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
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void end()
    {
        if(gameBoard.plane.points.size()==0&& !flag)
        {
            Door door1=new Door(gameBoard.plane.board.size()-4,gameBoard.plane.board.size()-4);
            gameBoard.plane.board.get(gameBoard.plane.board.size()-4).set(gameBoard.plane.board.size()-4, door1);
            door=door1;
            flag=true;
        }
    }
    public static void main(String [] args) throws FileNotFoundException {
       boulder_dash=new Boulder_Dash();





    }


}
