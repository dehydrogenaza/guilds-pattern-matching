package com.softwaremind;

import java.util.ArrayList;
import java.util.List;

import com.softwaremind.model.geom.Circle;
import com.softwaremind.model.geom.PizzaSlice;
import com.softwaremind.model.geom.Point;
import com.softwaremind.model.geom.Rectangle;
import com.softwaremind.model.geom.Shape2D;
import com.softwaremind.model.geom.Square;

public class RecordPatterns {
  public static void main(String[] args) {
    Circle circle = new Circle(new Point(0.0, 0.0), 5.0);
    Square square = new Square(new Point(1.0, 1.0), 3.0);
    Rectangle rectangle = new Rectangle(new Point(2.0, 2.0), new Point(5.0, 0.0));
    PizzaSlice largeSlice = new PizzaSlice(new Point(0.0, 0.0), 10.0, 45.0);
    PizzaSlice smallSlice = new PizzaSlice(new Point(0.0, 0.0), 3.0, 60.0);

    List<Shape2D> stuff = new ArrayList<>();
    stuff.add(circle);
    stuff.add(square);
    stuff.add(rectangle);
    stuff.add(largeSlice);
    stuff.add(smallSlice);

    for (int i = 0; i < stuff.size(); i++) {
      System.out.println("Processing item with index [" + i + "]");
      Shape2D item = stuff.get(i);

      String description = describeShape(item); //Java 21+
      System.out.println(description);

      System.out.println("\n");
    }
  }

  private static String describeShape(Shape2D item) {
    return switch (item) {

      //deconstruct record components directly
      case Circle(Point center, double radius)
          -> "It's a Circle with center at " + center + " and radius " + radius;

      //you can use 'var' to avoid repeating type names
      case Square(var topLeft, var sideLength)
          -> "It's a Square with top-left corner at " + topLeft + " and side length " + sideLength;

      //nested destructuring
      case Rectangle(Point(var topLeftX, var topLeftY), Point(var bottomRightX, var bottomRightY))
          -> "It's a Rectangle with top-left corner at (" + topLeftX + ", " + topLeftY
             + ") and bottom-right corner at (" + bottomRightX + ", " + bottomRightY + ")";

      //with type guards on record components
      case PizzaSlice(Point origin, double radius, double angleDegrees)
          when radius > 6.0
          -> "It's a YUGE PizzaSlice with origin at " + origin + ", radius " + radius
             + " and angle " + angleDegrees + " degrees. Nice!";

      //ignore components you don't care about with _
      case PizzaSlice(_, var radius, _) -> "It's just a PizzaSlice, not that big, radius " + radius;

      //how to get rid of this if we know the full list of types we should process?
      //answer: sealed interfaces
//      default -> "I don't know what this is, rigged game.";
    };
  }
}
