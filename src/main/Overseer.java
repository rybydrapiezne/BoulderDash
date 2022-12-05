package main;

import Game.*;
import Character.*;
import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Overseer extends JPanel {

    private Image wall_image;
    private Image dirt_image;
    private Image boulder_image;
    private Image player_image;
    private Image empty_image;
    Plane plane;

    public Image DrawPanel(String file_name){
        return new ImageIcon(file_name).getImage();
    }
    Overseer()  {
        wall_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\wall.png");
        dirt_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\dirt.png");
        boulder_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\boulder.png");
        player_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\player.png");
        empty_image=DrawPanel("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\empty.png");
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
                    g.drawImage(wall_image,index_y,index_x,this);

                    index_y+=25;
                }
                if(object instanceof Dirt)
                {
                    g.drawImage(dirt_image,index_y,index_x,this);

                    index_y+=25;
                }
                if(object instanceof Boulder)
                {
                    g.drawImage(boulder_image,index_y,index_x,this);

                    index_y+=25;
                }
                if(object instanceof Player)
                {
                    g.drawImage(player_image,index_y,index_x,this);
                    index_y+=25;
                }
                if(object instanceof Empty)
                {
                    g.drawImage(empty_image,index_y,index_x,this);
                    index_y+=25;
                }
            }
            index_y=10;
            index_x+=25;
        }

    }

}
