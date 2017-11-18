package jarOfT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Jar<String> jarStr = new Jar<>();
        Jar<Integer> jarInt = new Jar<>();

        jarStr.add("Gosho");
        jarStr.add("Pesho");
        jarStr.add("Mesho");
        jarStr.add("Tosho");
        jarStr.add("Fosho");

        jarStr.remove();
        jarStr.remove();

        for (String s : jarStr.getElements()) {
            System.out.println(s);
        }


    }
}
