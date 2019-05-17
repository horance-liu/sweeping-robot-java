package com.bosch.robot;

public class Position {
  private Point point;
  private Direction direction;

  public Position(int x, int y, Direction direction) {
    this(new Point(x, y), direction);
  }

  public Position(Point point, Direction direction) {
    this.point = point;
    this.direction = direction;
  }

  public Position turn(boolean left) {
    return new Position(point, direction.turn(left));
  }

  public Position move(int steps) {
    return new Position(direction.move(point, steps), direction);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Position))
      return false;
    Position other = (Position) obj;
    return point.equals(other.point) && direction == other.direction;
  }
}
