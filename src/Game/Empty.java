package Game;

import Help_Classes.Point;

public class Empty implements GameObject{
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
