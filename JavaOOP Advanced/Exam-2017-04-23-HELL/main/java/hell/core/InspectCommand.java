package hell.core;

import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;

public class InspectCommand extends BaseCommand {
    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String heroName = super.getParams()[0];
        Hero hero = super.getRepository().getHeroByName(heroName);
        return hero.toString();
        //return null;
    }
}
