package hell.Factory;

import hell.entities.items.CommonItem;
import hell.entities.items.RecipeItem;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.List;

public final class ItemFactory {
    private ItemFactory() {
    }

    public static Item createCommonItem(String name, int strengthBonus, int agilityBonus,
                                        int intelligenceBonus, int hitPointsBonus, int damageBonus) {

        Item commonItem = new CommonItem(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus);

        return commonItem;
    }

    public static Recipe createRecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                                          int hitPointsBonus, int damageBonus, List<String> requiredItems) {

        Recipe reicpeItem = new RecipeItem(name, strengthBonus, agilityBonus,
                intelligenceBonus, hitPointsBonus, damageBonus, requiredItems);

        return reicpeItem;
    }
}
