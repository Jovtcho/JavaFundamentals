package genericBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int elementsCount = Integer.parseInt(br.readLine());

        for (int index = 0; index < elementsCount; index++) {
            Box box = new Box<>(Integer.parseInt(br.readLine()));
            System.out.println(box);
        }
    }
}
