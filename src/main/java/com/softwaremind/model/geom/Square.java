package com.softwaremind.model.geom;

public record Square(Point center, double sideLength) implements Shape2D {

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    public Point bottomRight() {
        return new Point(center.x() + sideLength, center.y() - sideLength);
    }
}
