package petClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Clinic<Room>> clinics = new HashMap<>();
        Map<String, Pet> pets = new HashMap<>();
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = br.readLine().split("\\s+");
            String command = tokens[0];

            switch (command.toLowerCase()) {
                case "create":
                    if ("clinic".equalsIgnoreCase(tokens[1])) {
                        try {
                            Clinic<Room> clinic = new ClinicImpl<>(tokens[2], Integer.parseInt(tokens[3]));
                            clinics.putIfAbsent(tokens[2], clinic);
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    } else if ("pet".equalsIgnoreCase(tokens[1])) {
                        Pet pet = new PetImpl(tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
                        pets.putIfAbsent(tokens[2], pet);
                    } else {
                        System.out.println("No such command.");
                    }
                    break;
                case "hasemptyrooms":
                    if (clinics.containsKey(tokens[1])) {
                        System.out.println(clinics.get(tokens[1]).hasEmptyRooms());
                    }
                    break;
                case "release":
                    if (clinics.containsKey(tokens[1])) {
                        System.out.println(clinics.get(tokens[1]).release());
                    }
                    break;
                case "add":
                    if (pets.containsKey(tokens[1])) {
                        Pet pet = pets.get(tokens[1]);
                        if (clinics.containsKey(tokens[2])) {
                            Clinic<Room> clinic = clinics.get(tokens[2]);
                            System.out.println(clinic.addPet(pet));
                        }
                    } else {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "print":
                    if (tokens.length == 2) {
                        if (clinics.containsKey(tokens[1])) {
                            Clinic<Room> clinic = clinics.get(tokens[1]);
                            StringBuilder sb = new StringBuilder();
                            for (Room room : clinic) {
                                sb.append(room == null ? "Room empty" : room.toString());
                                sb.append(System.lineSeparator());
                            }
                            System.out.println(sb.toString().trim());
                        }
                    } else if (tokens.length == 3) {
                        if (clinics.containsKey(tokens[1])) {
                            clinics.get(tokens[1]).print(Integer.parseInt(tokens[2]));
                        }
                    } else {
                        System.out.println("No such command.");
                    }
                    break;
            }
        }

        System.out.println();
    }
}
