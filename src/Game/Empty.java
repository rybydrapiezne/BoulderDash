package Game;

public class Empty implements GameObject{
    @Override
    public int get_position() {
        return 0;
    }

    @Override
    public void move(int direction) {

    }

    @Override
    public boolean is_collision() {
        return false;
    }
}
