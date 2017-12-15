package hell.core;

import hell.Factory.ItemFactory;
import hell.interfaces.Hero;
import hell.interfaces.Item;

import java.lang.reflect.InvocationTargetException;

public class ItemCommand extends BaseCommand {

    private static final String ADDED_ITEM_TO_HERO_MESSAGE_FORMAT = "Added item - %s to Hero - %s";

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String itemName = super.getParams()[0];
        String heroName = super.getParams()[1];
        int strengthBonus = Integer.parseInt(super.getParams()[2]);
        int agilityBonus = Integer.parseInt(super.getParams()[3]);
        int intelligenceBonus = Integer.parseInt(super.getParams()[4]);
        int hitPointsBonus = Integer.parseInt(super.getParams()[5]);
        int damageBonus = Integer.parseInt(super.getParams()[6]);

        Hero hero = super.getRepository().getHeroByName(heroName);
        Item commonItem = ItemFactory.createCommonItem(itemName, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);

        if (hero != null && commonItem != null) {
            hero.addItem(commonItem);
            return String.format(ADDED_ITEM_TO_HERO_MESSAGE_FORMAT, commonItem.getName(), hero.getName());
        }

        return null;
    }
}
