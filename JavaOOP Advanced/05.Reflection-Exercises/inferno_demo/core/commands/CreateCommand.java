package inferno_demo.core.commands;

import inferno_demo.factories.CreateWeapon;
import inferno_demo.models.api.WeaponInterface;
import inferno_demo.core.BaseCommand;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreateCommand extends BaseCommand {
    private static final String PATH_TO_WEAPONS_FACTORY = "inferno_demo.factories.";
    private static final String CREATE_COMMAND = "Create";

    @Override
    //@SuppressWarnings("unchecked")
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String weaponType = super.getParams()[0].charAt(0) + super.getParams()[0].substring(1).toLowerCase();
        String weaponName = getParams()[1];
        Class<CreateWeapon> weaponClass = (Class<CreateWeapon>)
                Class.forName(PATH_TO_WEAPONS_FACTORY + CREATE_COMMAND + weaponType);

        WeaponInterface weaponInterface = null;
        if (weaponClass != null) {
            Method createMethod = weaponClass.getDeclaredMethod(CREATE_COMMAND.toLowerCase(), String.class);
            if (createMethod != null) {
                Constructor<CreateWeapon> constructor = weaponClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                CreateWeapon weapon = (CreateWeapon) constructor.newInstance();

                createMethod.setAccessible(true);
                weaponInterface = (WeaponInterface) createMethod.invoke(weapon, weaponName);
            }
        }

        //WeaponInterface weaponInterface = null;
        //switch (super.getParams()[0]) {
        //    case "AXE":
        //        weaponInterface = WeaponFactory.createAxeWeapon(super.getParams()[1]);
        //        break;
        //    case "SWORD":
        //        weaponInterface = WeaponFactory.createSwordWeapon(super.getParams()[1]);
        //        break;
        //    case "KNIFE":
        //        weaponInterface = WeaponFactory.createKnifeWeapon(super.getParams()[1]);
        //        break;
        //}
        super.getWeaponRepository().add(weaponInterface);
        return null;
    }
}
