package Board;

import java.util.ArrayList;

public class Plane {
    public static int SIZE=20;
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

    }

}
