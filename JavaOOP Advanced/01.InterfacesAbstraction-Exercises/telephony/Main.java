package telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Smartphone smartphone = new Smartphone();
        String[] numbers = br.readLine().split("\\s+");
        String[] urls = br.readLine().split("\\s+");

        for (String number : numbers) {
            System.out.println(smartphone.call(number));
        }

        for (String url : urls) {
            System.out.println(smartphone.browse(url));
        }
    }
}
