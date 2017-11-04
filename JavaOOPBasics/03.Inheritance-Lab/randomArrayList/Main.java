package randomArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Object> objects = new RandomArrayList<>();
        objects.add(10);
        objects.add(200);
        objects.add('G');
        objects.add("HOHO");
        objects.add(10.34);
        objects.add(123.456);
        objects.add("TEST");
        objects.add('z');

        System.out.println(objects.toString());
        System.out.println(objects.getRandomElement());
        System.out.println(objects.toString());

    }
}
