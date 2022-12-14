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
    private Boulder_Clock boulder_clock;

    Game_form(Boulder_Dash boulder_dash,JFrame frame) throws FileNotFoundException {
        plane=new Plane(boulder_dash.options.difficulty);
        overseer1.plane=plane;
        boulder_clock=new Boulder_Clock();
        boulder_clock.plane=plane;
        clock1.frame=frame;
        boulder_clock.frame=frame;
        if(plane.boulders.size()!=0) {
            boulder_clock.boulders=plane.boulders;
        }
        }
    private void createUIComponents()  {
        clock1=new Clock();
        overseer1=new Overseer(clock1);

    }




}
