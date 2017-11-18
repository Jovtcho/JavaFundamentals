package nullFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        Collections.addAll(listStr, null, "Pesh", "GOG", "ads", null, "zdh");

        List<Integer> listInt = new ArrayList<>();
        Collections.addAll(listInt, 1, null, 6, 99, null, null, 8, -4);


        // System.out.println(ListUtils.getMin(listStr));
        // System.out.println(ListUtils.getMax(listStr));
        System.out.println(Arrays.toString(ListUtils.getNullIndices(listStr).toArray()));
        //System.out.println(ListUtils.getMin(listInt));
        //System.out.println(ListUtils.getMax(listInt));
        System.out.println(Arrays.toString(ListUtils.getNullIndices(listInt).toArray()));
    }
}
