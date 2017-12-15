package hell.entities.heroes;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.*;


public abstract class BaseHero implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private Inventory inventory;

    protected BaseHero(String name, long strength, long agility, long intelligence,
                       long hitPoints, long damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Item> items = new HashMap<>();
        //List<Item> items = new ArrayList<>();
        Class<?> inventoryClass = this.inventory.getClass();
        Field[] fields = inventoryClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                items = (Map<String, Item>) field.get(this.inventory);
            }
        }

        return items.values();
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        //Hero: Ivan, Class: Barbarian
        //HitPoints: 450, Damage: 200
        //Strength: 115
        //Agility: 35
        //Intelligence: 20
        //Items:
        //###Item: Spear
        //###+25 Strength
        //###+10 Agility
        //###+10 Intelligence
        //###+100 HitPoints
        //###+50 Damage
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage())).append(System.lineSeparator());
        sb.append(String.format("Strength: %d", this.getStrength())).append(System.lineSeparator());
        sb.append(String.format("Agility: %d", this.getAgility())).append(System.lineSeparator());
        sb.append(String.format("Intelligence: %d", this.getIntelligence())).append(System.lineSeparator());

        try {
            if (this.getItems().isEmpty()) {
                sb.append("Items: None").append(System.lineSeparator());
            } else {
                sb.append("Items:").append(System.lineSeparator());
                for (Item item : this.getItems()) {
                    sb.append(String.format("###Item: %s", item.getName())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Strength", item.getStrengthBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Agility", item.getAgilityBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Intelligence", item.getIntelligenceBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d HitPoints", item.getHitPointsBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Damage", item.getDamageBonus())).append(System.lineSeparator());
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
