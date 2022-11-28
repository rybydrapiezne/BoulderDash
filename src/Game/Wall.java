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
}
