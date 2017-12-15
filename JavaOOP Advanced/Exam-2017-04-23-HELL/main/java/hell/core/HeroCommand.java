package hell.core;

import hell.Factory.HeroFactory;
import hell.interfaces.Hero;

import java.lang.reflect.InvocationTargetException;

public class HeroCommand extends BaseCommand {

    private static final String CREATED_HERO_MESSAGE_FORMAT = "Created %s - %s";

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = super.getParams()[0];
        String type = super.getParams()[1];

        Hero hero = HeroFactory.create(name, type);
        if (hero != null) {
            super.getRepository().add(hero);
            return String.format(CREATED_HERO_MESSAGE_FORMAT, type, name);
        }

        return null;
    }
}
