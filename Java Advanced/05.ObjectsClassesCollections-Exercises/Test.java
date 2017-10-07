import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    //   while (true) {
    //       List<String> materials = new LinkedList<>();
    //       String[] line = bf.readLine().toLowerCase().split("\\s+");

    //       List<Integer> quantity = Arrays.stream(line).filter(el -> {
    //           try {
    //               Integer.valueOf(el);
    //               return true;
    //           } catch (Exception e) {
    //               materials.add(el);
    //               return false;
    //           }
    //       }).map(Integer::valueOf).collect(Collectors.toList());

    //       System.out.println(Arrays.toString(materials.toArray()).replaceAll("[\\[\\],]", ""));
    //       System.out.println(Arrays.toString(quantity.toArray()).replaceAll("[\\[\\],]", ""));
    //       System.out.println("================================================");
    //   }
    }
}
