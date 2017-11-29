package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Unit;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends BaseCommand{

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException,
            InstantiationException, IllegalAccessException, InvocationTargetException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
        //return null;
    }
}
