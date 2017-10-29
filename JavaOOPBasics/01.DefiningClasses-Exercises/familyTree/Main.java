package familyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String searchedPerson = br.readLine();
        List<String> lines = new ArrayList<>();
        List<String> parents = new ArrayList<>();
        List<String> children = new ArrayList<>();

        Person person = null;
        if (searchedPerson.contains("/")) {
            person = new Person("", searchedPerson);
        } else {
            person = new Person(searchedPerson, "");
        }

        while (true) {
            String line = br.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }
            lines.add(line);
        }

        person = getPersonNameAndBirthday(lines, person);
        String removeSearchedPersonStr = person.getName() + " " + person.getBirthday();
        lines.removeIf(line -> line.equals(removeSearchedPersonStr));

        for (String line : lines) {
            String[] lineTokens = line.split(" - ");

            if (lineTokens.length > 1) {
                String parentNameOrDate = lineTokens[0].trim();
                String childNameOrDate = lineTokens[1].trim();
                if (parentNameOrDate.equals(person.getName()) || parentNameOrDate.equals(person.getBirthday())) {
                    children.add(childNameOrDate);
                } else if (childNameOrDate.equals(person.getName()) || childNameOrDate.equals(person.getBirthday())) {
                    parents.add(parentNameOrDate);
                }
            }
        }

        lines.removeIf(line -> line.contains("-"));

        for (int index = 0; index < parents.size(); index++) {
            for (String line : lines) {
                String[] lineTokens = line.split("\\s+");
                String name = lineTokens[0] + " " + lineTokens[1];
                String date = lineTokens[2];

                if (parents.get(index).equals(name) || parents.get(index).equals(date)) {
                    person.addParent(name, date);
                    break;
                }
            }
        }

        for (int index = 0; index < children.size(); index++) {
            for (String line : lines) {
                String[] lineTokens = line.split("\\s+");
                String name = lineTokens[0] + " " + lineTokens[1];
                String date = lineTokens[2];

                if (children.get(index).equals(name) || children.get(index).equals(date)) {
                    person.addChild(name, date);
                    break;
                }
            }
        }

        System.out.print(person.toString());
    }

    private static Person getPersonNameAndBirthday(List<String> lines, Person person) {
        for (String line : lines) {
            if (!line.contains(" - ")) {
                String[] tokens = line.split("\\s+");
                if ("".equals(person.getName())) {
                    String birthday = person.getBirthday();
                    if (line.contains(birthday)) {
                        String name = tokens[0] + " " + tokens[1];
                        person.setName(name);
                        break;
                    }
                } else if ("".equals(person.getBirthday())) {
                    String name = person.getName();
                    if (line.contains(name)) {
                        String birthday = tokens[2];
                        person.setBirthday(birthday);
                        break;

                    }
                }
            }
        }
        return person;
    }
}
