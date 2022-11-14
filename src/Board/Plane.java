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
            board.get(0).add(new Wall(0,i));
            board.get(i).add(new Wall(i,i));
        }

        boolean flag=false;
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                if(board.get(i).get(j) instanceof Wall)
                {
                    flag=true;
                    System.out.print(1);

                }
                else {
                    if(!flag)
                    System.out.print(0);
                }
                }
            flag=false;
            System.out.println();
        }
    }
}
