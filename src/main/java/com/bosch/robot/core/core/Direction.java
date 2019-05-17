package com.bosch.robot.core.core;

public enum Direction {
  EAST(1, 0), SOUTH(0, -1), WEST(-1, 0), NORTH(0, 1);

  private int xOffset;
  private int yOffset;

  private Direction(int xOffset, int yOffset) {
    this.xOffset = xOffset;
    this.yOffset = yOffset;
  }

  public Direction turn(boolean left) {
    int numOfTurns = left ? 3 : 1;
    return values()[(ordinal() + numOfTurns) % 4];
  }

  public Point move(Point from, int steps) {
    return from.move(steps * xOffset, steps * yOffset);
  }
}
