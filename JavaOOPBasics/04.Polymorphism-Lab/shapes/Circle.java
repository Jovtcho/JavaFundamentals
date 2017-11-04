package shapes;

public class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return this.radius;
    }

    @Override
    protected double calculatePerimeter() {
        return (2 * Math.PI * this.radius);
    }

    @Override
    protected double calculateArea() {
        return (Math.PI * this.radius * this.radius);
    }
}
