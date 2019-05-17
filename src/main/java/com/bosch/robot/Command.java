package com.bosch.robot;

@FunctionalInterface
public interface Command {
  Position exec(Position from);
}
