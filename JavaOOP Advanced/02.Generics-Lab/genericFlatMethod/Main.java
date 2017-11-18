package genericFlatMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> listDouble = new ArrayList<>();
        Collections.addAll(listDouble, 12.3, 45.65, -23.9, 0D, 1.3, 1D);

        List<Integer> listInt = new ArrayList<>();
        Collections.addAll(listInt, 1, 6, 99, 8, -4);

        List<List<? extends Number>> source = new ArrayList<>();
        Collections.addAll(source, listDouble, listInt);

        List<Number> dest = new ArrayList<>();
        ListUtils.flatten(dest, source);
        System.out.println(dest);
    }
}
