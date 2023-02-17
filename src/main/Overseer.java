package main;

import Game.*;
import Character.*;
import javax.swing.*;
import java.awt.*;

public class Overseer extends JPanel {

    private final Image wall_image;
    private final Image dirt_image;
    private final Image boulder_image;
    private final Image player_image;
    private final Image empty_image;
    private final Image point_image;
    Plane plane;
    Clock clock;

    public Image DrawPanel(String file_name){
        return new ImageIcon(file_name).getImage();
    }
    Overseer(Clock clock)  {
        this.clock=clock;
        wall_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\wall.png");
        dirt_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\dirt.png");
        boulder_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\boulder.png");
        player_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\player.png");
        empty_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\empty.png");
        point_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\point.png");
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index_x=10;
        int index_y=10;
        if(plane==null)
            return;
        g.setColor(Color.BLACK);
        //g.drawLine(10,10,600,600);

        for(int i=0;i<plane.board.size();i++)
        {
            for(int j=0;j<plane.board.get(i).size();j++)
            {

                GameObject object=plane.board.get(i).get(j);
                if(object instanceof Wall)
                {
                    g.drawImage(wall_image,index_x,index_y,this);

                    index_x+=25;
                }
                if(object instanceof Dirt)
                {
                    g.drawImage(dirt_image,index_x,index_y,this);

                    index_x+=25;
                }
                if(object instanceof Boulder)
                {
                    g.drawImage(boulder_image,index_x,index_y,this);

                    index_x+=25;
                }
                if(object instanceof Player)
                {
                    g.drawImage(player_image,index_x,index_y,this);
                    index_x+=25;
                }
                if(object instanceof Empty)
                {
                    g.drawImage(empty_image,index_x,index_y,this);
                    index_x+=25;
                }
                if(object instanceof Game.Point)
                {
                    g.drawImage(point_image,index_x,index_y,this);
                    index_x+=25;
                }
            }
            index_x=10;
            index_y+=25;
        }
        //clock.repaint();


    }

}
