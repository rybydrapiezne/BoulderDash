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
        return new Help_Classes.Point(x,y);
    }

    @Override
    public void move(int direction) {
        y++;
    }

    @Override
    public boolean is_collision() {
        return false;
    }


}
