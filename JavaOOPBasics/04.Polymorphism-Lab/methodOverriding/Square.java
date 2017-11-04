package methodOverriding;

public class Square extends Rectangle {
    public Square(double side) {
        super(side);
    }

    @Override
    public double calculateArea() {
        return this.getSideA() * this.getSideA();
    }
}
