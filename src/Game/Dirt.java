package Game;

public class Dirt implements GameObject{
    int x;
    int y;
    Dirt(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public int get_position() {
        return 0;
    }
}
