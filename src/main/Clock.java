package main;

import Game.Boulder;
import Game.Empty;
import Game.Plane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends JPanel {
    Timer timer;
    Integer interval;
    int delay = 1000;
    int period = 1000;
    private final Image one;
    private final Image two;
    private final Image three;
    private final Image four;
    private final Image five;
    private final Image six;
    private final Image seven;
    private final Image eight;
    private final Image nine;
    private final Image zero;
    Score score;
    int time;
    ArrayList<Boulder> boulders;
    Plane plane;
    JFrame frame;

    public Image DrawPanel(String file_name) {
        return new ImageIcon(file_name).getImage();
    }

    Clock() {

        one = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\one.png");
        two = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\two.png");
        three = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\three.png");
        four = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\four.png");
        five = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\five.png");
        six = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\six.png");
        seven = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\seven.png");
        eight = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\eight.png");
        nine = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\nine.png");
        zero = DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\zero.png");
        timer = new Timer();
        interval = 121;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                time = setInterval();
                score.repaint();
                repaint();


            }
        }, delay, period);
    }

    private int setInterval() {
        if (interval == 1)
            timer.cancel();

        return --interval;
    }

    @Override
    public void paintComponent(Graphics g) {

        int number;
        int x = 500;
        int y = 0;
        int time_local = time;

        while (time_local > 0) {
            number = time_local % 10;
            time_local = time_local / 10;
          //  System.out.println(time_local);
            switch (number) {
                case 1 -> {
                    g.drawImage(one, x, y, this);
                    x -= 50;

                }
                case 2 -> {
                    g.drawImage(two, x, y, this);
                    x -= 50;


                }
                case 3 -> {
                    g.drawImage(three, x, y, this);
                    x -= 50;


                }
                case 4 -> {
                    g.drawImage(four, x, y, this);
                    x -= 50;


                }
                case 5 -> {
                    g.drawImage(five, x, y, this);
                    x -= 50;


                }
                case 6 -> {
                    g.drawImage(six, x, y, this);
                    x -= 50;


                }
                case 7 -> {
                    g.drawImage(seven, x, y, this);
                    x -= 50;


                }
                case 8 -> {
                    g.drawImage(eight, x, y, this);
                    x -= 50;


                }
                case 9 -> {
                    g.drawImage(nine, x, y, this);
                    x -= 50;


                }
                case 0 -> {
                    g.drawImage(zero, x, y, this);
                    x -= 50;


                }
            }
        }

    }
}
