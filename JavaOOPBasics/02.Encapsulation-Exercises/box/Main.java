package box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(br.readLine());
        double width = Double.parseDouble(br.readLine());
        double height = Double.parseDouble(br.readLine());

        System.out.printf("Surface Area - %.2f%n", Box.getSurfaceArea(length, width, height));
        System.out.printf("Lateral Surface Area - %.2f%n", Box.getLateralSurfaceArea(length, width, height));
        System.out.printf("Volume - %.2f%n", Box.getVolume(length, width, height));
    }
}
