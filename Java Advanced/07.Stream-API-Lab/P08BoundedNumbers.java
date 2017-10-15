import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P08BoundedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //int[] bound = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        List<Integer> bounds = Arrays.stream(bf.readLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toList());
        List<String> tokens = Arrays.asList(bf.readLine().split("\\s+"));
        //int lowerBound = Math.min(bound[0], bound[1]);
        //int upperBound = Math.max(bound[0], bound[1]);

        List<Integer> filteredNums = tokens.stream()
                .filter(s -> (s != null && !s.isEmpty()))
                .map(Integer::valueOf)
                .filter(x -> (Collections.min(bounds) <= x && x <= Collections.max(bounds)))
                .collect(Collectors.toList());

        if (filteredNums.isEmpty()) {
            return;
        } else {
            System.out.println(Arrays.toString(filteredNums.toArray())
                    .replaceAll("[\\[\\],]", ""));
        }
    }
}
