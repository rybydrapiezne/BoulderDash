package Game;

public class Point implements GameObject{
    int x;
    int y;
    Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public Help_Classes.Point get_position() {
        return null;
    }

    @Override
    public void move(int direction) {

    }

    @Override
    public boolean is_collision() {
        return true;
    }


}
