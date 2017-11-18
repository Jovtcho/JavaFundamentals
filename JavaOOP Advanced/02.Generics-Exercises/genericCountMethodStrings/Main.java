package genericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elementsCount = Integer.parseInt(br.readLine());
        List<Box<String>> list = new ArrayList<>();

        for (int index = 0; index < elementsCount; index++) {
            list.add(new Box<>(br.readLine()));
        }

        Box<String> givenBox = new Box<>(br.readLine());

        System.out.println(Box.countGreaterElements(list, givenBox));
    }
}
