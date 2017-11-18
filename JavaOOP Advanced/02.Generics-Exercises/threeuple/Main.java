package threeuple;

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
        Threeuple<String, String, String> nameAddress = new Threeuple<>(name, line1[2], line1[3]);
        Threeuple<String, Integer, Boolean> nameLiters = new Threeuple<>(line2[0], Integer.parseInt(line2[1]),
                line2[2].equals("drunk") ? true : false);
        Threeuple<String, Double, String> nameBank = new Threeuple<>(line3[0],
                Double.parseDouble(line3[1]), line3[2]);

        System.out.println(nameAddress.toString());
        System.out.println(nameLiters.toString());
        System.out.println(nameBank.toString());
    }
}
