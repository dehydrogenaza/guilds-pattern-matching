package com.softwaremind.model.geom;

public record PizzaSlice(
    Point origin,
    double radius,
    double angleDegrees
) implements Shape2D {

    @Override
    public double calculateArea() {
        return (angleDegrees / 360.0) * Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        double arcLength = (angleDegrees / 360.0) * 2 * Math.PI * radius;
        return arcLength + 2 * radius;
    }
}
