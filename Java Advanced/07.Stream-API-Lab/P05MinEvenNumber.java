import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class P05MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     // Optional<Double> minEven = Arrays.stream(bf.readLine().split("\\s+"))
     //         .filter(s -> (s != null && !s.isEmpty()))
     //         .map(Double::valueOf)
     //         .filter(x -> x % 2 == 0)
     //         .min(Double::compare);

     // if (minEven.isPresent()) {
     //     System.out.printf("%.2f", minEven.get());
     // } else {
     //     System.out.println("No match");
     // }

        OptionalDouble minEven = Arrays.stream(bf.readLine().split("\\s+"))
                .filter(s -> (s != null && !s.isEmpty()))
                .mapToDouble(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .min();

        if (minEven.isPresent()) {
            System.out.printf("%.2f", minEven.getAsDouble());
        } else {
            System.out.println("No match");
        }



    }
}
