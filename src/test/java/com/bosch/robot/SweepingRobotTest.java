package com.bosch.robot;

import org.junit.Test;

import static com.bosch.robot.Direction.*;
import static com.bosch.robot.Commands.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SweepingRobotTest {
  @Test
  public void left_cmd() {
    exec(left(), position(0, 0, WEST));
  }

  @Test
  public void right_cmd() {
    exec(right(), position(0, 0, EAST));
  }

  @Test
  public void left_right_cmd() {
    exec(sequential(left(), right()), position(0, 0, NORTH));
  }

  @Test
  public void right_left_cmd() {
    exec(sequential(right(), left()), position(0, 0, NORTH));
  }

  @Test
  public void forward_cmd() {
    exec(forward(), position(0, 1, NORTH));
  }

  @Test
  public void double_forward_cmd() {
    exec(repeat(forward(), 2), position(0, 2, NORTH));
  }

  @Test
  public void backward_cmd() {
    exec(backward(), position(0, -1, NORTH));
  }

  @Test
  public void double_backward_cmd() {
    exec(repeat(backward(), 2), position(0, -2, NORTH));
  }

  @Test
  public void forward_backward_cmd() {
    exec(sequential(forward(), backward()), position(0, 0, NORTH));
  }

  @Test
  public void forward_n_cmd() {
    exec(forward(2), position(0, 2, NORTH));
  }

  @Test
  public void backward_n_cmd() {
    exec(backward(2), position(0, -2, NORTH));
  }

  @Test
  public void forward_n_then_backward_n_cmd() {
    exec(sequential(forward(2), backward(2)), position(0, 0, NORTH));
  }

  @Test
  public void round_cmd() {
    exec(round(), position(0, 0, SOUTH));
  }

  @Test
  public void double_round_cmd() {
    exec(sequential(round(), round()), position(0, 0, NORTH));
  }

  @Test
  public void repeat_cmd() {
    exec(repeat(forward(), 2), position(0, 2, NORTH));
  }
  
  private void exec(Command cmd, Position newPosition) {
    robot.exec(cmd);
    assertThat(robot.position(), equalTo(newPosition));
  }

  private static Position position(int x, int y, Direction direction) {
    return new Position(x, y, direction);
  }

  private SweepingRobot robot = new SweepingRobot();
}
