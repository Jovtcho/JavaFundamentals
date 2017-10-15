import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class P04AverageOfDoubles {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

     //  List<Double> nums = Arrays.stream(bf.readLine().split("\\s+"))
     //          .filter(s -> (s != null && !s.isEmpty()))
     //          .map(Double::valueOf)
     //          .collect(Collectors.toList());
     //  DoubleStream numsStream = nums.stream().mapToDouble(Double::valueOf);
     //  OptionalDouble average = numsStream.average();

        OptionalDouble averageOneRow = Arrays.stream(bf.readLine().split("\\s+"))
                .filter(s -> (s!=null && !s.isEmpty()))
                .mapToDouble(Double::parseDouble)
                .average();

        if (averageOneRow.isPresent()) {
            System.out.printf("%.2f%n", averageOneRow.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
