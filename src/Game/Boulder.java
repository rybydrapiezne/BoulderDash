package Game;

import Help_Classes.Point;

public class Boulder implements GameObject {
    int x;
    int y;
    Boulder(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public Help_Classes.Point get_position() {
        return new Point(x,y);
    }

    @Override
    public void move(int direction) {
        y++;
    }

    @Override
    public boolean is_collision() {
        return true;
    }


}
