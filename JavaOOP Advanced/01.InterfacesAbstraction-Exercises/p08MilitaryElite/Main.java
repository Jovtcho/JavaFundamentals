package p08MilitaryElite;

import p08MilitaryElite.models.Mission;
import p08MilitaryElite.models.Repair;
import p08MilitaryElite.models.factory.Factory;
import p08MilitaryElite.models.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Map<Integer, Soldier> army = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String input = br.readLine();

            if ("end".equalsIgnoreCase(input))
                break;

            createSoldier(input);

        }

        army.forEach((id, soldier) -> System.out.println(soldier.toString()));
    }

    private static void createSoldier(String input) {
        String[] commandLine = input.split("\\s+");
        String type = commandLine[0];
        int id = Integer.valueOf(commandLine[1]);
        String firstName = commandLine[2];
        String lastName = commandLine[3];
        double salary;
        String corpus;
        String codeNumber;

        switch (type) {
            case "Private":
                salary = Double.valueOf(commandLine[4]);
                army.put(id, Factory.createPrivate(id, firstName, lastName, salary));
                break;
            case "LeutenantGeneral":
                salary = Double.valueOf(commandLine[4]);
                army.put(id, Factory.createLeutenantGeneral(id, firstName, lastName, salary));

                if (commandLine.length < 6)
                    break;

                List<Integer> privatesIds = new ArrayList<>();
                for (int i = 5; i < commandLine.length; i++) {
                    privatesIds.add(Integer.valueOf(commandLine[i]));
                }
                privatesIds.forEach(privateId ->
                        LeutenantGeneral.class.cast(army.get(id))
                                .addPrivate(Private.class.cast(army.get(privateId))));
                break;
            case "Engineer":
                salary = Double.valueOf(commandLine[4]);
                corpus = commandLine[5];
                if (corpus.equals("Airforces") || corpus.equals("Marines")) {
                    army.put(id, Factory.createEngineer(id, firstName, lastName, salary, corpus));

                    if (commandLine.length < 7)
                        break;

                    for (int i = 6; i < commandLine.length; i += 2) {
                        String part = commandLine[i];
                        int hours = Integer.valueOf(commandLine[i + 1]);

                        Engineer.class.cast(army.get(id))
                                .addRepair(new Repair(part, hours));
                    }
                }
                break;
            case "Commando":
                salary = Double.valueOf(commandLine[4]);
                corpus = commandLine[5];
                if (corpus.equals("Airforces") || corpus.equals("Marines")) {
                    army.put(id, Factory.createCommando(id, firstName, lastName, salary, corpus));
                    if (commandLine.length < 7)
                        break;
                    for (int i = 6; i < commandLine.length; i += 2) {
                        String codeName = commandLine[i];
                        String state = commandLine[i + 1];
                        if (state.equals("finished") || state.equals("inProgress"))
                            Commando.class.cast(army.get(id))
                                    .addMission(new Mission(codeName, state));
                    }
                }
                break;
            case "Spy":
                codeNumber = commandLine[4];
                army.put(id, Factory.createSpy(id, firstName, lastName, codeNumber));
                break;
        }
    }
}
