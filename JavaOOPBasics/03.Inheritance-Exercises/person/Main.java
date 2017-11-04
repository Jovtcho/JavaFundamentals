package person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int age = Integer.parseInt(br.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());
            //String personClassName = Person.class.getSimpleName();
            //String childClassName = Child.class.getSimpleName();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
