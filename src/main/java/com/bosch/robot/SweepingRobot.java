package com.bosch.robot;

public class SweepingRobot {
  private Position pos = new Position(0, 0, Direction.NORTH);

  public void exec(Command cmd) {
    pos = cmd.exec(pos);
  }

  public Position position() {
    return pos;
  }
}
