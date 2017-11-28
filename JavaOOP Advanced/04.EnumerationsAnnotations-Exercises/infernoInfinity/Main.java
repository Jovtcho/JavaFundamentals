package infernoInfinity;

import infernoInfinity.Factories.GemFactory;
import infernoInfinity.Factories.WeaponFactory;
import infernoInfinity.annotations.CustomAnnotation;
import infernoInfinity.entities.Interfaces.Weapon;
import infernoInfinity.enumerations.GemType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new LinkedHashMap<>();

        while (true) {
            String input = br.readLine();
            if ("END".equalsIgnoreCase(input)) {
                break;
            }

            List<String> tokens = Arrays.stream(input.split(";"))
                    .map(String::valueOf).collect(Collectors.toList());
            CustomAnnotation customAnnotation = Weapon.class.getDeclaredAnnotation(CustomAnnotation.class);
            String command = tokens.remove(0);

            switch (command.toLowerCase()) {
                case "create":
                    Weapon weapon = WeaponFactory.createWeapon(tokens);
                    if (weapon != null) {
                        weapons.putIfAbsent(tokens.get(0), weapon);
                    }
                    break;
                case "add":
                    if (weapons.containsKey(tokens.get(0))) {
                        GemType gem = GemFactory.createGem(tokens.get(2));
                        if (gem != null) {
                            weapons.get(tokens.get(0)).addGem(gem, Integer.parseInt(tokens.get(1)));
                        }
                    }
                    break;
                case "remove":
                    if (weapons.containsKey(tokens.get(0))) {
                        weapons.get(tokens.get(0)).removeGem(Integer.parseInt(tokens.get(1)));
                    }
                    break;
                case "compare":
                    if (weapons.containsKey(tokens.get(0)) && weapons.containsKey(tokens.get(1))) {
                        Weapon firstWeapon = weapons.get(tokens.get(0));
                        Weapon secondWeapon = weapons.get(tokens.get(1));
                        if (firstWeapon.compareTo(secondWeapon) >= 0) {
                            System.out.println(firstWeapon.print());
                        } else {
                            System.out.println(secondWeapon.print());
                        }
                    }
                    break;
                case "print":
                    if (weapons.containsKey(tokens.get(0))) {
                        System.out.println(weapons.get(tokens.get(0)).toString());
                    }
                    break;
                case "author":
                    System.out.printf("Author: %s%n", customAnnotation.author());
                    break;
                case "revision":
                    System.out.printf("Revision: %d%n", customAnnotation.revision());
                    break;
                case "description":
                    System.out.printf("Class description: %s%n", customAnnotation.description());
                    break;
                case "reviewers":
                    System.out.printf("Reviewers: %s%n", String.join(", ", customAnnotation.reviewers()));
                    break;
                default:
                    System.out.println("No such command.");
            }
        }
    }
}
