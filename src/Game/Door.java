package Game;

import Help_Classes.Point;

public class Door implements GameObject{
    int x;
    int y;
    public Door(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public Point get_position() {
        return new Point(x,y);
    }

    @Override
    public void move(int direction) {

    }

    @Override
    public boolean is_collision() {
        return false;
    }
}
