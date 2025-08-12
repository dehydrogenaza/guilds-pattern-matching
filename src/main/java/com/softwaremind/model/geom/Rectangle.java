package com.softwaremind.model.geom;

public record Rectangle(Point topLeft, Point bottomRight) implements Shape2D {
    @Override
    public double calculateArea() {
        double width = bottomRight.x() - topLeft.x();
        double height = topLeft.y() - bottomRight.y();
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        double width = bottomRight.x() - topLeft.x();
        double height = topLeft.y() - bottomRight.y();
        return 2 * (width + height);
    }

    public Point topRight() {
        return new Point(bottomRight.x(), topLeft.y());
    }

    public Point bottomLeft() {
        return new Point(topLeft.x(), bottomRight.y());
    }
}
