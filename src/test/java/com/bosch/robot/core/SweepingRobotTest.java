package com.bosch.robot.core;

import com.bosch.robot.core.cmd.Command;
import com.bosch.robot.core.cmd.Commands;
import com.bosch.robot.core.core.Direction;
import com.bosch.robot.core.core.Position;
import com.bosch.robot.core.core.SweepingRobot;

import org.junit.Test;

import static com.bosch.robot.core.core.Direction.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SweepingRobotTest {
  @Test
  public void left_cmd() {
    exec(Commands.left(), position(0, 0, WEST));
  }

  @Test
  public void right_cmd() {
    exec(Commands.right(), position(0, 0, EAST));
  }

  @Test
  public void left_right_cmd() {
    exec(Commands.sequential(Commands.left(), Commands.right()), position(0, 0, NORTH));
  }

  @Test
  public void right_left_cmd() {
    exec(Commands.sequential(Commands.right(), Commands.left()), position(0, 0, NORTH));
  }

  @Test
  public void forward_cmd() {
    exec(Commands.forward(), position(0, 1, NORTH));
  }

  @Test
  public void double_forward_cmd() {
    exec(Commands.repeat(Commands.forward(), 2), position(0, 2, NORTH));
  }

  @Test
  public void backward_cmd() {
    exec(Commands.backward(), position(0, -1, NORTH));
  }

  @Test
  public void double_backward_cmd() {
    exec(Commands.repeat(Commands.backward(), 2), position(0, -2, NORTH));
  }

  @Test
  public void forward_backward_cmd() {
    exec(Commands.sequential(Commands.forward(), Commands.backward()), position(0, 0, NORTH));
  }

  @Test
  public void forward_n_cmd() {
    exec(Commands.forward(2), position(0, 2, NORTH));
  }

  @Test
  public void backward_n_cmd() {
    exec(Commands.backward(2), position(0, -2, NORTH));
  }

  @Test
  public void forward_n_then_backward_n_cmd() {
    exec(Commands.sequential(Commands.forward(2), Commands.backward(2)), position(0, 0, NORTH));
  }

  @Test
  public void round_cmd() {
    exec(Commands.round(), position(0, 0, SOUTH));
  }

  @Test
  public void double_round_cmd() {
    exec(Commands.sequential(Commands.round(), Commands.round()), position(0, 0, NORTH));
  }

  @Test
  public void repeat_cmd() {
    exec(Commands.repeat(Commands.forward(), 2), position(0, 2, NORTH));
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
