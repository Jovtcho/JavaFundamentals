package genericAddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> listDouble = new ArrayList<>();
        Collections.addAll(listDouble, 12.3, null, 45.65, -23.9, null, 0D, 1.3, 1D);

        List<Integer> listInt = new ArrayList<>();
        Collections.addAll(listInt, 1, null, 6, 99, null, null, 8, -4);

        List<Number> dest = new ArrayList<>();
        ListUtils.addAll(dest, listDouble);
        ListUtils.addAll(dest, listInt);
        System.out.println(dest);
    }
}
