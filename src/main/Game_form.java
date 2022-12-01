package main;

import Game.Plane;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Game_form {
    Plane plane;

    Overseer overseer1;
    JPanel board;
    Game_form(Boulder_Dash boulder_dash) throws FileNotFoundException {
        plane=new Plane(boulder_dash.options.difficulty);
        overseer1.plane=plane;

    }
    private void createUIComponents()  {
        overseer1=new Overseer();
    }
}
