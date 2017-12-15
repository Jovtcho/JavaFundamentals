import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, OperationNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] numbers = Arrays.stream(br.readLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);

        try {
            Database database = new Database(numbers);
            System.out.println();
            database.add(45);
            database.add(145);
            database.add(445);
            database.add(455);
            database.remove();
        } catch (OperationNotSupportedException onse) {
            System.out.println("Wrong array size");
        }


    }
}
