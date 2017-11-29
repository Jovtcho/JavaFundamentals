package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends BaseCommand {

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        String unitType = super.getData()[1];
        super.getRepository().removeUnit(unitType);
        return unitType + " retired!";
        //return null;
    }
}
