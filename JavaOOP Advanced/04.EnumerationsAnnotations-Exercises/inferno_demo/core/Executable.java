package inferno_demo.core;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
