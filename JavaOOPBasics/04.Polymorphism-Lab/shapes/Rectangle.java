package shapes;

public class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    @Override
    protected double calculatePerimeter() {
        return (2 * this.width + 2 * this.height);
    }

    @Override
    protected double calculateArea() {
        return (this.width * this.height);
    }
}
