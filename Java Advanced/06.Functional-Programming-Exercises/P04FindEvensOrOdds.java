import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class P04FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        int lowerBorder = Integer.valueOf(line[0]);
        int upperBorder = Integer.valueOf(line[1]);
        String command = bf.readLine();

        Predicate<Integer> testerEvenOrOdd = getIsEvenOrOdd(command);

        for (int i = lowerBorder; i <= upperBorder; i++) {
            if (testerEvenOrOdd.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static Predicate<Integer> getIsEvenOrOdd(String command) {
        if ("even".equalsIgnoreCase(command)) {
            return num -> num % 2 == 0;
        } else if ("odd".equalsIgnoreCase(command)) {
            return num -> num % 2 != 0;
        } else {
            return null;
        }
    }
}
