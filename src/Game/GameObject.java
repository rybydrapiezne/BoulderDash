package Game;

public interface GameObject {
 int get_position();
 void move(int direction);

 boolean is_collision();
}
