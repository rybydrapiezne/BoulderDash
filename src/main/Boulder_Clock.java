package main;

import Game.Boulder;
import Game.Empty;
import Game.Plane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Boulder_Clock {
    Timer timer;
    Integer interval;
    int delay = 250;
    int period = 250;
    int time;
    ArrayList<Boulder> boulders;
    Plane plane;
    JFrame frame;
    Boulder_Clock()
    {

        timer=new Timer();
        interval=1000000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                time = setInterval();
                for(int i=0;i<boulders.size();i++)
                {
                    if(plane.board.get(boulders.get(i).get_position().y+1).get(boulders.get(i).get_position().x) instanceof Empty)
                    {
                        Boulder boulder=boulders.get(i);
                        plane.board.get(boulder.get_position().y).set(boulder.get_position().x,new Empty());
                        boulder.move(0);

                        plane.board.get(boulder.get_position().y).set(boulder.get_position().x, boulder);
                        frame.repaint();
                    }
                }



            }
        },delay,period);
    }
    private int setInterval()
    {
        if(interval==1)
            timer.cancel();

        return --interval;
    }
}

