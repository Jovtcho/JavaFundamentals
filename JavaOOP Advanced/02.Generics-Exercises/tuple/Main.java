package tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split("\\s+");
        String[] line2 = br.readLine().split("\\s+");
        String[] line3 = br.readLine().split("\\s+");

        String name = line1[0] + " " + line1[1];
        Tuple<String, String> nameAddress = new Tuple<>(name, line1[2]);
        Tuple<String, Integer> nameLiters = new Tuple<>(line2[0], Integer.parseInt(line2[1]));
        Tuple<Integer, Double> integerDouble = new Tuple<>(Integer.parseInt(line3[0]), Double.parseDouble(line3[1]));

        System.out.println(nameAddress.toString());
        System.out.println(nameLiters.toString());
        System.out.println(integerDouble.toString());

    }
}
