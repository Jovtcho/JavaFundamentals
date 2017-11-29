package pr0304Barracks.core.commands;

import java.lang.reflect.InvocationTargetException;

public class FightCommand extends BaseCommand {
    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return "fight";
    }
}
