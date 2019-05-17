package com.bosch.robot.core.cmd;

import com.bosch.robot.core.core.Position;

@FunctionalInterface
public interface Command {
  Position exec(Position from);
}
