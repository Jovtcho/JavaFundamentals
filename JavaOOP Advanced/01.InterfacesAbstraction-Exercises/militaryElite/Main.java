package militaryElite;

import militaryElite.implementations.*;
import militaryElite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, ISoldier> soldiers = new LinkedHashMap<>();

        while (true) {
            String line = br.readLine();
            if ("End".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String soldierType = tokens[0];


            switch (soldierType.toLowerCase()) {
                case "private":
                    //Private <id> <firstName> <lastName> <salary>
                    Private privateSoldier = new Private(Integer.parseInt(tokens[1]), tokens[2],
                            tokens[3], Double.parseDouble(tokens[4]));
                    soldiers.put(Integer.parseInt(tokens[1]), privateSoldier);
                    break;
                case "spy":
                    //Spy <id> <firstName> <lastName> <codeNumber>”
                    Spy spy = new Spy(Integer.parseInt(tokens[1]), tokens[2],
                            tokens[3], tokens[4]);
                    soldiers.put(Integer.parseInt(tokens[1]), spy);
                    break;
                case "leutenantgeneral":
                    //LeutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id> … <privateNId>
                    ILeutenantGeneral leutenantGeneral = new LeutenantGeneral(Integer.parseInt(tokens[1]), tokens[2],
                            tokens[3], Double.parseDouble(tokens[4]));

                    for (int i = 5; i < tokens.length; i++) {
                        int privateId = Integer.parseInt(tokens[i]);
                        if (soldiers.containsKey(privateId)) {
                            leutenantGeneral.addPrivate((Private) soldiers.get(privateId));
                        }
                    }

                    soldiers.put(Integer.parseInt(tokens[1]), leutenantGeneral);
                    break;
                case "engineer":
                    //Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> … <repairNPart> <repairNHours>
                    try {
                        IEngineer engineer = new Engineer(Integer.parseInt(tokens[1]), tokens[2],
                                tokens[3], Double.parseDouble(tokens[4]), tokens[5]);

                        for (int i = 6; i < tokens.length; i += 2) {
                            String repairName = tokens[i];
                            int repairHoursWorked = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new Repair(repairName, repairHoursWorked);
                            engineer.addRepair(repair);
                        }

                        soldiers.put(Integer.parseInt(tokens[1]), engineer);
                    } catch (IllegalArgumentException iae) {
                    }
                    break;
                case "commando":
                    //Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> … <missionNCodeName> <missionNstate>
                    try {
                        ICommando commando = new Commando(Integer.parseInt(tokens[1]), tokens[2],
                                tokens[3], Double.parseDouble(tokens[4]), tokens[5]);

                        for (int i = 6; i < tokens.length; i += 2) {
                            String codeName = tokens[i];
                            String state = tokens[i + 1];
                            try {
                                Mission mission = new Mission(codeName, state);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException iae) {
                            }
                        }
                        soldiers.put(Integer.parseInt(tokens[1]), commando);
                    } catch (IllegalArgumentException iae) {
                    }
                    break;
                default:
                    System.out.println("No such command.");
                    break;
            }
        }

        for (ISoldier soldier : soldiers.values()) {
            System.out.println(soldier.toString());
        }
    }
}
