package cresla.engine;

import cresla.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "Exit";
    //private static final String COMMAND_CLASS_PATH = "hell.core.";
    //private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Manager manager;

    public Engine(InputReader reader, OutputWriter writer, Manager manager) {
        this.reader = reader;
        this.writer = writer;
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            this.params = Arrays.stream(this.reader.readLine().split("\\s+")).collect(Collectors.toList());
            String command = this.params.remove(0);
            try {
                String result = this.dispatchCommand(command, this.params);
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(command)) {
                break;
            }
        }
    }


    private String dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        switch (command) {
            case "Reactor":
                return this.manager.reactorCommand(tokens);
            case "Module":
                return this.manager.moduleCommand(tokens);
            case "Report":
                return this.manager.reportCommand(tokens);
            case "Exit":
                return this.manager.exitCommand(tokens);
            default:
                return null;
        }
    }
}
