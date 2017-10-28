package animalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chickenName = br.readLine();
        int chickenAge = Integer.parseInt(br.readLine());

        try {
            Chicken chicken = new Chicken(chickenName, chickenAge);
            System.out.println(chicken.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
