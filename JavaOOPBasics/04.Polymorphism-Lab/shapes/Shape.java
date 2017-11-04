package shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    Shape() {
    }

    double getPerimeter() {
        return this.perimeter;
    }

    void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    double getArea() {
        return this.area;
    }

    void setArea(double area) {
        this.area = area;
    }

    protected abstract double calculatePerimeter();

    protected abstract double calculateArea();
}
