package Game;
import Character.Player;
import Help_Classes.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Plane {
    public static int SIZE=27;
    public static int LEVEL_LENGTH =5;
    int number_of_boulders;
    public Point player_position;
   public ArrayList<ArrayList<GameObject>> board;
   public ArrayList<Boulder> boulders;
    public Plane(Difficulty difficulty) throws FileNotFoundException {

        set_difficulty(difficulty);
        board=new ArrayList<>();
        for(int i=0;i<SIZE;i++) {
            board.add(new ArrayList<>());
        }
        boulders=new ArrayList<>();
        set_plane(difficulty);


        /*for(int i=0;i<SIZE;i++)
        {
            board.get(0).set(i,new Wall(0,i));
            board.get(i).set(board.get(i).size()-1, new Wall(i,i));
            board.get(board.size()-1).set(i,new Wall(board.size()-1, i));
            board.get(i).set(0,new Wall(i,0));
        }*/
        //inner_walls();
        //generate_boulders();
    }
    private void set_plane(Difficulty difficulty) throws FileNotFoundException
    {
        Scanner scanner=null;
        String line;
        int row=0;
        File file=null;
        try{
        switch (difficulty)
        {
            case Easy -> {
                file= new File("C:\\Users\\Szymon\\IdeaProjects\\BoulderDash\\src\\Game\\map_easy.txt");
                scanner=new Scanner(file);
            }
            case Medium -> {
                scanner=new Scanner("map_medium.txt");
            }
            case Hard -> {
                scanner=new Scanner("map_hard.txt");
            }
        }}
        catch (FileNotFoundException fileNotFoundException)
        {

        }

        while (scanner.hasNext())
        {
            line=scanner.nextLine();
            //System.out.println(line);
            for(int i=0;i<line.length();i++)
            {
                switch (line.charAt(i))
                {
                    case'0':
                    {
                        board.get(row).add(new Dirt(i,row));
                        break;
                    }
                    case '1':
                    {
                        board.get(row).add(new Wall(i,row));
                        break;
                    }
                    case '2':
                    {
                        Boulder boulder=new Boulder(i,row);
                        board.get(row).add(boulder);

                            boulders.add(boulder);
                        break;
                    }
                    case'4': {
                        board.get(row).add(new Player(i, row));
                        player_position=new Point(i,row);
                        break;
                    }
                    case '3':{
                        board.get(row).add(new Game.Point(i, row));
                        break;
                    }

                }
            }
            row++;

        }
    }
    /*public void inner_walls()
    {
        boolean flag=false;
        for(int i = LEVEL_LENGTH; i< board.size(); i+= LEVEL_LENGTH)
        {
            if(!flag) {
                for (int j = 1; j < board.get(i).size() - 1 - LEVEL_LENGTH; j++) {
                    board.get(i).set(j, new Wall(i, j));
                    flag=true;
                }
            }
            else {
                for (int j = board.get(i).size() - 2; j > LEVEL_LENGTH; j--)
                    board.get(i).set(j, new Wall(i, j));
                    flag=false;
            }
        }
    }*/
    public void print_text_board()
    {
        for(int i=0;i<board.size();i++)
        {
            for(int j=0;j<board.get(i).size();j++)
            {
                if(board.get(i).get(j) instanceof Wall)
                    System.out.print("1");
                else if(board.get(i).get(j) instanceof Dirt)
                    System.out.print("0");
                else if(board.get(i).get(j) instanceof Boulder)
                    System.out.print("2");
            }
            System.out.println();
        }
    }
    public void generate_boulders()
    {
        Random random=new Random();
        int x;
        int y;
        for(int i=0;i<number_of_boulders;)
        {
            x= random.nextInt(1,board.size()-1);
            y=random.nextInt(1,board.size()-1);
            if(!(board.get(x).get(y) instanceof Wall))
            {
                i++;
                board.get(x).set(y,new Boulder(x,y));
            }
        }
    }

    public void set_difficulty(Difficulty difficulty)
    {
        switch (difficulty)
        {
            case Easy -> number_of_boulders=50;
            case Medium -> number_of_boulders=75;
            case Hard -> number_of_boulders=100;

        }
    }
}
