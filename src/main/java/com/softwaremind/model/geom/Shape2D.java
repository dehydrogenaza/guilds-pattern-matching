package com.softwaremind.model.geom;

public sealed interface Shape2D permits Circle, PizzaSlice, Rectangle, Square {
  double calculateArea();
  double calculatePerimeter();
}
