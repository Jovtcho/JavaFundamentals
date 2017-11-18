package listUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();
        Collections.addAll(listStr, "Pesh", "GOG", "ads", "zdh");

        List<Integer> listInt = new ArrayList<>();
        Collections.addAll(listInt, 1, 6, 99, 8, -4);


        System.out.println(ListUtils.getMin(listStr));
        System.out.println(ListUtils.getMax(listStr));
        System.out.println(ListUtils.getMin(listInt));
        System.out.println(ListUtils.getMax(listInt));
    }
}
