package Game;

import Help_Classes.Point;

public class Wall implements GameObject {
    int x;
    int y;
    Wall(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public Point get_position() {
        return new Help_Classes.Point(x,y);
    }

    @Override
    public void move(int direction) {

    }

    @Override
    public boolean is_collision() {
        return true;
    }


}
