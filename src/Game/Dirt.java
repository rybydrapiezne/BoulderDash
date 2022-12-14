package Game;

import Help_Classes.Point;

public class Dirt implements GameObject{
    int x;
    int y;
    Dirt(int x,int y)
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

    }

    @Override
    public boolean is_collision() {
        return false;
    }


}
