package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    private static final String OUTPUT_FORMAT = "%s %s %s";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Class cl = RichSoilLand.class;
        Field[] clFields = cl.getDeclaredFields();

        // Field test = clFields[2];
        // System.out.println(Modifier.toString(test.getModifiers()) + " " + test.getType().getSimpleName() + " " + test.getName());

        while (true) {
            String command = br.readLine();
            if ("HARVEST".equalsIgnoreCase(command)) {
                break;
            }

            switch (command) {
                case "private":
                    Arrays.stream(clFields)
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.println(String.format(OUTPUT_FORMAT,
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName())));
                    break;
                case "protected":
                    Arrays.stream(clFields)
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.println(String.format(OUTPUT_FORMAT,
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName())));
                    break;
                case "public":
                    Arrays.stream(clFields)
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.println(String.format(OUTPUT_FORMAT,
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName())));
                    break;
                case "all":
                    Arrays.stream(clFields)
                            .forEach(field -> System.out.println(String.format(OUTPUT_FORMAT,
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName())));
                    break;
                default:
                    System.out.println("No such command.");

            }
        }
    }
}