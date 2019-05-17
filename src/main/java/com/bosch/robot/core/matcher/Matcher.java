package com.bosch.robot.core.matcher;

import com.bosch.robot.core.core.Point;

public interface Matcher {
  void notify(Point point);
  boolean matches(Point point);
}
