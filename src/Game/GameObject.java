package Game;

import Help_Classes.Point;

public interface GameObject {
 Point get_position();
 void move(int direction);

 boolean is_collision();
}
