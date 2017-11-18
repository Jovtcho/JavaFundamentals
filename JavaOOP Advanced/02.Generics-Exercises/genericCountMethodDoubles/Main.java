package genericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elementsCount = Integer.parseInt(br.readLine());
        List<Box<Double>> list = new ArrayList<>();

        for (int index = 0; index < elementsCount; index++) {
            list.add(new Box<>(Double.parseDouble(br.readLine())));
        }

        Box<Double> givenBox = new Box<>(Double.parseDouble(br.readLine()));

        System.out.println(Box.countGreaterElements(list, givenBox));
    }
}
