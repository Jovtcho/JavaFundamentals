package pr0304Barracks.core;

import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMAND_PACKAGE_NAME = "pr0304Barracks.core.commands.";
    private static final String COMMAND_CLASS_SUFFIX = "Command";
    private static final String COMMAND_NOT_FOUND = "Invalid command!";
//    private static final String COMMAND_EXECUTE_METHOD = "execute";

    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String commandClassName = String.valueOf(commandName.charAt(0)).toUpperCase()
                + commandName.substring(1) + COMMAND_CLASS_SUFFIX;

        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMAND_PACKAGE_NAME + commandClassName);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException(COMMAND_NOT_FOUND);
        }

        Constructor<?> commandConstructor = commandClass.getDeclaredConstructor();
        Executable command = (Executable) commandConstructor.newInstance();
//        Method executeMethod = commandClass.getDeclaredMethod(COMMAND_EXECUTE_METHOD);

        return command;
    }
}
