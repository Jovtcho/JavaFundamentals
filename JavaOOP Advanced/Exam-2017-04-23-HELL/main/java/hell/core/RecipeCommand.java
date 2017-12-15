package hell.core;

import hell.Factory.ItemFactory;
import hell.interfaces.Hero;
import hell.interfaces.Recipe;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecipeCommand extends BaseCommand {

    private static final String ADDED_RECIPE_TO_HERO_MESSAGE_FORMAT = "Added recipe - %s to Hero - %s";

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String recipeName = super.getParams()[0];
        String heroName = super.getParams()[1];
        int strengthBonus = Integer.parseInt(super.getParams()[2]);
        int agilityBonus = Integer.parseInt(super.getParams()[3]);
        int intelligenceBonus = Integer.parseInt(super.getParams()[4]);
        int hitPointsBonus = Integer.parseInt(super.getParams()[5]);
        int damageBonus = Integer.parseInt(super.getParams()[6]);

        List<String> requiredItems = new ArrayList<>();
        for (int i = 7; i < super.getParams().length; i++) {
            requiredItems.add(super.getParams()[i]);
        }

        Hero hero = super.getRepository().getHeroByName(heroName);
        Recipe recipeItem = ItemFactory.createRecipeItem(recipeName, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);

        if (hero != null && recipeItem != null) {
            hero.addRecipe(recipeItem);
            return String.format(ADDED_RECIPE_TO_HERO_MESSAGE_FORMAT, recipeItem.getName(), hero.getName());
        }

        return null;
    }
}
