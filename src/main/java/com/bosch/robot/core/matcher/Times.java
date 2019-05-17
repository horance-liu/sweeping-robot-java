package com.bosch.robot.core.matcher;

import com.bosch.robot.core.core.Point;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class Times implements Matcher {
  private int limit;
  private Map<Point, Integer> cache = new HashMap<>();

  public Times(int limit) {
    this.limit = limit;
  }

  @Override
  public void notify(Point point) {
    Integer num = cache.get(point);
    cache.put(point, num != null ? num + 1 : 1);
  }

  @Override
  public boolean matches(Point point) {
    Integer num = cache.get(point);
    return num != null && num == limit;
  }
}
