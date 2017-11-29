package pr0304Barracks.core;

import pr0304Barracks.annotations.Inject;
import pr0304Barracks.contracts.*;
import pr0304Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private static final String COMMAND_CLASS_PATH = "pr0304Barracks.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;
    private String[] data;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] tokens = input.split("\\s+");
                String commandName = tokens[0];
                //String result = interpredCommand(data, commandName);
                String result = dispatchCommand(commandName, tokens);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4     ***** DONE *****
    // private String interpredCommand(String[] data, String commandName)
    //         throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    //     String result;
    //     switch (commandName) {
    //         case "add":
    //             result = this.addUnitCommand(data);
    //             break;
    //         case "report":
    //             result = this.reportCommand(data);
    //             break;
    //         case "fight":
    //             result = this.fightCommand(data);
    //             break;
    //         default:
    //             throw new RuntimeException("Invalid command!");
    //     }
    //     return result;
    // }

    private String dispatchCommand(String command, String[] tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.data = tokens;
        command = command.toUpperCase().charAt(0) + command.substring(1).toLowerCase();
        String fullClassPath = COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(fullClassPath);
        Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor();
        Executable executable = declaredConstructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] currentFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }

    //private String reportCommand(String[] data) {
    //    String output = this.repository.getStatistics();
    //    return output;
    //}

    //private String addUnitCommand(String[] data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    //    String unitType = data[1];
    //    Unit unitToAdd = this.unitFactory.createUnit(unitType);
    //    this.repository.addUnit(unitToAdd);
    //    String output = unitType + " added!";
    //    return output;
    //}

    //private String fightCommand(String[] data) {
    //    return "fight";
    //}
}
