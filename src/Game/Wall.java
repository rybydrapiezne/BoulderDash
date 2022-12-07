package Game;

public class Wall implements GameObject {
    int x;
    int y;
    Wall(int x,int y)
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

    }

    @Override
    public boolean is_collision() {
        return true;
    }


}
