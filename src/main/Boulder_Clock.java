package main;

import Game.Boulder;
import Game.Empty;
import Game.Plane;
import Character.Player;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Boulder_Clock {
    Timer timer;
    Integer interval;
    int delay = 300;
    int period = 300;
    int time;
   boolean k=false;
    ArrayList<Boulder> boulders;
    ArrayList<Game.Point> points;
    Plane plane;
    JFrame frame;
    End_Screen end;
    Boulder_Clock()  {


        timer=new Timer();
        interval=10000000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(k==true) {
                    end=new End_Screen(frame);
                    frame.setContentPane(end.end_screen);
                    frame.pack();
                    frame.setVisible(true);
                    k= false;
                    timer.cancel();
                }
                time = setInterval();
                for(int i=0;i<boulders.size();i++)
                {
                    if(plane.board.get(boulders.get(i).get_position().y+1).get(boulders.get(i).get_position().x) instanceof Empty||plane.board.get(boulders.get(i).get_position().y+1).get(boulders.get(i).get_position().x) instanceof Player)
                    {
                        if(plane.board.get(boulders.get(i).get_position().y+1).get(boulders.get(i).get_position().x) instanceof Player)
                        {
                            k=true;
                        }
                        Boulder boulder=boulders.get(i);
                        plane.board.get(boulder.get_position().y).set(boulder.get_position().x,new Empty());
                        boulder.move(0);

                        plane.board.get(boulder.get_position().y).set(boulder.get_position().x, boulder);

                        frame.repaint();
                    }

                }
                for(int i=0;i<points.size();i++) {
                    if (plane.board.get(points.get(i).get_position().y + 1).get(points.get(i).get_position().x) instanceof Empty) {
                        Game.Point point = points.get(i);
                        plane.board.get(point.get_position().y).set(point.get_position().x, new Empty());
                        point.move(0);

                        plane.board.get(point.get_position().y).set(point.get_position().x, point);
                        frame.repaint();
                    }
                    if (plane.board.get(points.get(i).get_position().y + 1).get(points.get(i).get_position().x) instanceof Player) {
                        Game.Point point = points.get(i);
                        plane.board.get(point.get_position().y).set(point.get_position().x, new Empty());
                        point.move(0);
                        k=true;
                        plane.board.get(point.get_position().y).set(point.get_position().x, point);
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

