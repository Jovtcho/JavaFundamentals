package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, IOException, NoSuchFieldException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Class<BlackBoxInt> cl = BlackBoxInt.class;

        Constructor[] constructors = cl.getDeclaredConstructors();
        Constructor constructor = Arrays.stream(constructors)
                .filter(c -> c.getParameterCount() == 0)
                .findFirst()
                .get();

        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

        while (true) {
            String inputLine = br.readLine();
            if ("END".equalsIgnoreCase(inputLine)) {
                break;
            }

            String[] tokens = inputLine.split("_");
            String command = tokens[0];
            int operand = Integer.parseInt(tokens[1]);

            Method method = null;

            switch (command.toLowerCase()) {
                case "add":
                    method = blackBoxInt.getClass().getDeclaredMethod("add", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                case "subtract":
                    method = blackBoxInt.getClass().getDeclaredMethod("subtract", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                case "divide":
                    method = blackBoxInt.getClass().getDeclaredMethod("divide", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                case "multiply":
                    method = blackBoxInt.getClass().getDeclaredMethod("multiply", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                case "rightshift":
                    method = blackBoxInt.getClass().getDeclaredMethod("rightShift", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                case "leftshift":
                    method = blackBoxInt.getClass().getDeclaredMethod("leftShift", int.class);
                    System.out.println(getValue(blackBoxInt, operand, method));
                    break;
                default:
                    System.out.println("No such command.");
            }
        }
    }

    private static String getValue(BlackBoxInt blackBoxInt, int operand, Method method) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        method.setAccessible(true);
        method.invoke(blackBoxInt, operand);
        Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
        field.setAccessible(true);
        Object value = field.get(blackBoxInt);
        return value.toString();
    }
}
