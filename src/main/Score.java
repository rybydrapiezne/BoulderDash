package main;

import javax.swing.*;
import java.awt.*;

public class Score extends JPanel {

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
    int score;
    int current_point_score;
    int time;
    Clock clock;
    Game_form form;
    public Image DrawPanel(String file_name){
        return new ImageIcon(file_name).getImage();
    }
    Score(Clock clock)
    {
        if(form!=null)
        current_point_score=form.current_point_score;
        this.clock=clock;
        time=clock.time;

        score=100*current_point_score+clock.time;
        one=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\one.png");
        two=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\two.png");
        three=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\three.png");
        four=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\four.png");
        five=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\five.png");
        six=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\six.png");
        seven=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\seven.png");
        eight=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\eight.png");
        nine=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\nine.png");
        zero=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\zero.png");
    } @Override
    public void paintComponent(Graphics g){

        int number;
        int x=500;
        int y=0;
        time=clock.time;
        score=10*(10*form.current_point_score+time);
        int temp_score=score;
        while(temp_score>0) {

            number= temp_score % 10;
            temp_score = temp_score / 10;
            switch (number) {
                case 1 -> {
                    g.drawImage(one, x, y, this);
                    x -= 50;
                   // repaint();
                }
                case 2 -> {
                    g.drawImage(two, x, y, this);
                    x -= 50;
                   // repaint();
                }
                case 3 -> {
                    g.drawImage(three, x, y, this);
                    x -= 50;
                   // repaint();
                }
                case 4 -> {
                    g.drawImage(four, x, y, this);
                    x -= 50;
                    //repaint();
                }
                case 5 -> {
                    g.drawImage(five, x, y, this);
                    x -= 50;
                   // repaint();
                }
                case 6 -> {
                    g.drawImage(six, x, y, this);
                    x -= 50;
                   // repaint();
                }
                case 7 -> {
                    g.drawImage(seven, x, y, this);
                    x -= 50;
                    //repaint();
                }
                case 8 -> {
                    g.drawImage(eight, x, y, this);
                    x -= 50;
                    //repaint();
                }
                case 9 -> {
                    g.drawImage(nine, x, y, this);
                    x -= 50;
                    //repaint();
                }
                case 0 -> {
                    g.drawImage(zero, x, y, this);
                    x -= 50;
                    //repaint();
                }
            }
        }

    }
}
