package firstReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int peopleCount = Integer.parseInt(br.readLine());
        Team myTeam = new Team("MyTeam");

        for (int index = 0; index < peopleCount; index++) {
            String[] tokens = br.readLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            double salary = Double.parseDouble(tokens[3]);
            Person player = new Person(firstName, lastName, age, salary);
            myTeam.addPlayer(player);
            //myTeam.getFirstTeam().add(player);

        }

        System.out.printf("First team have %d players%n", myTeam.getTeamCount("first"));
        System.out.printf("Reserve team have %d players%n", myTeam.getTeamCount("reserve"));
    }
}
