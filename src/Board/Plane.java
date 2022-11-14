package Board;

import java.util.ArrayList;
import java.util.Random;

public class Plane {
    public static int SIZE=20;
    public static int LEVEL_LENGTH =5;
    int number_of_boulders;

   public ArrayList<ArrayList<GameObject>> board;
    public Plane(Difficulty difficulty)
    {

        set_difficulty(difficulty);
        board=new ArrayList<>();
        for(int i=0;i<SIZE;i++) {
            board.add(new ArrayList<>());
        }
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
                board.get(i).add(new Dirt());
        }

        for(int i=0;i<SIZE;i++)
        {
            board.get(0).set(i,new Wall(0,i));
            board.get(i).set(board.get(i).size()-1, new Wall(i,i));
            board.get(board.size()-1).set(i,new Wall(board.size()-1, i));
            board.get(i).set(0,new Wall(i,0));
        }
        inner_walls();
        generate_boulders();
    }

    public void inner_walls()
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
    }
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
