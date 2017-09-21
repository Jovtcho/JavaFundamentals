import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Scanner Console = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(Console.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = Console.nextLine().split("\\s+");
        String type = command[2];
        int count = Integer.parseInt(command[1]);
        List<Integer> container = new ArrayList<>();

        for (Integer num : nums) {
            boolean a = Get(type, num);

            if (type.equals("odd") && a)
                container.add(num);

            if (type.equals("even") && a) {
                container.add(num);
            }

            if (Array.getLength(container.toArray()) >= count)
                break;
        }

        List<String> numms = container.stream().map(e -> String.valueOf(e)).collect(Collectors.toList());
        System.out.println(String.join(" ", numms));
    }

    public static boolean Get(String type, Integer num) {
        if (type.equals("odd"))
            return num % 2 != 0;

        if (type.equals("even"))
            return num % 2 == 0;

        return false;
    }
}