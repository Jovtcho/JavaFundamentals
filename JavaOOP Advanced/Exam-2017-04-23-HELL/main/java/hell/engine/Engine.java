package hell.engine;

import hell.core.Executable;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.InputReader;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repository.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "Quit";
    private static final String COMMAND_CLASS_PATH = "hell.core.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    @ItemCollection
    private String[] params;
    @ItemCollection
    private Repository heroRepository;

    private InputReader reader;
    private OutputWriter writer;

    public Engine(Repository heroRepository, InputReader reader, OutputWriter writer) {
        this.heroRepository = heroRepository;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            this.params = this.reader.readLine().split("\\s+");
            String exit = this.params[0];
            try {
                String result = this.dispatchCommand(this.params[0],
                        Arrays.stream(this.params).skip(1).toArray(String[]::new));
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(exit)) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, String[] tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(
                COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> declaredConstructor = commandClass.getDeclaredConstructor();
        Executable executable = declaredConstructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getSuperclass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (currentField.isAnnotationPresent(ItemCollection.class)) {
                        if (field.getType().equals(currentField.getType())) {
                            field.setAccessible(true);
                            field.set(executable, currentField.get(this));
                        }
                    }
                }
            }
        }
    }
}
