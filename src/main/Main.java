package main;

import Board.Difficulty;
import Board.Plane;

public class Main {
    public static void main(String [] args)
    {
        Plane plane=new Plane(Difficulty.Hard);
        plane.print_text_board();
    }
}
