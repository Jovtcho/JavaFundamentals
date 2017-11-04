package shapes;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(6, 7);
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());

        Shape circle = new Circle(10);
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());
    }
}
