package Character;

import Game.GameObject;
import Help_Classes.Point;

public class Player implements GameObject {
    int x;
    int y;
    public Player(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public Point get_position() {
        return null;
    }

    @Override
    public void move(int direction) {
        switch (direction)
        {
            case 1:
                x++;
                break;
            case 2:
                x--;
            case 3:
                y++;
            case 4:
                y--;
        }

    }

    @Override
    public boolean is_collision() {
        return false;
    }


}
