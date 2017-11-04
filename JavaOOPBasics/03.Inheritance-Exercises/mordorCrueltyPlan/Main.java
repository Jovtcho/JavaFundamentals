package mordorCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] foods = br.readLine().split("\\s+");

        Wizard gandalf = new Wizard();
        gandalf.eatAllFoods(foods);
        System.out.println(gandalf.toString());
    }
}
