package shapesDrawing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Drawable circle = new Circle(4);
        Drawable rectangle = new Rectangle(5, 4);
        circle.draw();
        rectangle.draw();
    }
}
