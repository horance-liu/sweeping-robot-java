package com.bosch.robot.core.cmd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Commands {
  public static Command left() {
    return from -> from.turn(true);
  }

  public static Command right() {
    return from -> from.turn(false);
  }

  public static Command forward(int n) {
    return move(1, n);
  }

  public static Command forward() {
    return forward(1);
  }

  public static Command backward(int n) {
    return move(-1, n);
  }

  public static Command backward() {
    return backward(1);
  }

  public static Command round() {
    return repeat(right(), 2);
  }

  private static Command sequential(List<Command> cmds) {
    return from -> cmds.stream()
      .reduce(from, (pos, cmd) -> cmd.exec(pos), (a, b) -> null);
  }

  public static Command sequential(Command... cmds) {
    return sequential(Arrays.asList(cmds));
  }

  private static Command move(int steps) {
    return from -> from.move(steps);
  }

  private final static Command NOP = from -> from;

  private static boolean between(int num, int min, int max) {
    return min <= num && num <= max;
  }

  private static final int MIN_MOVE_NUM = 1;
  private static final int MAX_MOVE_NUM = 10;

  private static Command move(int sign, int n) {
    if (between(n, MIN_MOVE_NUM, MAX_MOVE_NUM))
      return move(sign * n);
    return NOP;
  }

  private static final int MIN_REPEAT_NUM = 1;
  private static final int MAX_REPEAT_NUM = 10;

  public static Command repeat(Command cmd, int n) {
    if (between(n, MIN_REPEAT_NUM, MAX_REPEAT_NUM))
      return sequential(Collections.nCopies(n, cmd));
    return NOP;
  }

  private Commands() {
  }
}
