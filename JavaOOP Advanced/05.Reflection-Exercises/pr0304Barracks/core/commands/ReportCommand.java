package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand extends BaseCommand {
    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String output = this.getRepository().getStatistics();
        return output;
    }
}
