package methodOverriding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Rectangle> rectangles = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] tokens = br.readLine().split("\\s+");
            if (tokens.length == 1) {
                rectangles.add(new Square(Double.parseDouble(tokens[0])));
            } else {
                rectangles.add(new Rectangle(Double.parseDouble(tokens[0]), Double.parseDouble(tokens[1])));
            }
        }

        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle.calculateArea());
        }
    }
}
