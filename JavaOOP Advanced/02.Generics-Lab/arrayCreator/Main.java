package arrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Integer[] integers = ArrayCreator.create(5, 2);
        String[] strings = ArrayCreator.create(String.class, 5, "OPA");

       // System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(strings));

    }
}
