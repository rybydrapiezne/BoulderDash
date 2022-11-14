package Board;

import java.util.ArrayList;

public class Plane {
    public static int SIZE=20;
    public static int LEVEL_LENGHT=5;
   public ArrayList<ArrayList<GameObject>> board;
    public Plane()
    {

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
    }

    public void inner_walls()
    {
        boolean flag=false;
        for(int i=LEVEL_LENGHT;i< board.size();i+=LEVEL_LENGHT)
        {
            if(!flag) {
                for (int j = 1; j < board.get(i).size() - 1 - LEVEL_LENGHT; j++) {
                    board.get(i).set(j, new Wall(i, j));
                    flag=true;
                }
            }
            else {
                for (int j = board.get(i).size() - 2; j > LEVEL_LENGHT; j--)
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
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }
}
