package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr0304Barracks.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // TODO: implement for problem 3    ***** DONE *****

        Class<?> cl = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> constructor = cl.getConstructor();
        Unit unit = (Unit) constructor.newInstance();
        // if (unit != null) {
        return unit;
        // }
        //throw new NotImplementedException();
    }
}
