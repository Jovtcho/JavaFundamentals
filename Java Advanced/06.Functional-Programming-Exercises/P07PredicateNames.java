import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class P07PredicateNames {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int lengthLimit = Integer.valueOf(bf.readLine());
        String[] names = bf.readLine().split("\\s+");
        Predicate<String> checkStrLength = str -> str.length() <= lengthLimit;

        for (String name : names) {
            if (checkStrLength.test(name)) {
                System.out.println(name);
            }
        }
    }
}

