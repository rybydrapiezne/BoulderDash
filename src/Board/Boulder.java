package Board;

public class Boulder implements GameObject {
    int x;
    int y;
    Boulder(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    @Override
    public int get_position() {
        return 0;
    }
}
