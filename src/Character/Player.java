package Character;

import Game.GameObject;

public class Player implements GameObject {
    int x;
    int y;
    public Player(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public int get_position() {
        return 0;
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
