package genericSwapMethodIntegers;

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
        List<Box> list = new ArrayList<>();

        for (int index = 0; index < elementsCount; index++) {
            list.add(new Box<>(Integer.parseInt(br.readLine())));
        }

        int[] indexes = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Box.swapElements(list, indexes[0], indexes[1]);

        for (Box box : list) {
            System.out.println(box);
        }
    }
}
