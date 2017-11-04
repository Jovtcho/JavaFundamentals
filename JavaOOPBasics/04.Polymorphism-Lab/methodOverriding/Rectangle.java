package methodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    Rectangle(double sideA) {
        this.sideA = sideA;
    }

    double getSideA() {
        return this.sideA;
    }

    public double calculateArea() {
        return this.sideA * this.sideB;
    }
}
