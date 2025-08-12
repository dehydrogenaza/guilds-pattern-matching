package com.softwaremind.model.geom;

public record Circle(Point center, double radius) implements Shape2D {

  @Override
  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double calculatePerimeter() {
    return 2 * Math.PI * radius;
  }

}
