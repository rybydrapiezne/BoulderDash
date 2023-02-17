package main;

import Game.Plane;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Game_form {
    Plane plane;

    Overseer overseer1;
    JPanel board;
    private Clock clock1;
    private Score score1;
    private Boulder_Clock boulder_clock;
    int current_point_score;


    Game_form(Boulder_Dash boulder_dash,JFrame frame) throws FileNotFoundException {
        plane=new Plane(boulder_dash.options.difficulty);
        overseer1.plane=plane;
        boulder_clock=new Boulder_Clock();
        boulder_clock.plane=plane;
        score1.form=this;
        clock1.frame=frame;
        boulder_clock.frame=frame;
        clock1.score=score1;


        if(plane.boulders.size()!=0) {
            boulder_clock.boulders=plane.boulders;
        }
        if(plane.points.size()!=0)
        {
            boulder_clock.points=plane.points;
        }
        }
    private void createUIComponents()  {
        clock1=new Clock();
        overseer1=new Overseer(clock1);
        score1=new Score(clock1);

    }




}
