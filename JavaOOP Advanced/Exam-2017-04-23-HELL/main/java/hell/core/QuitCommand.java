package hell.core;

import hell.interfaces.Item;

import java.lang.reflect.InvocationTargetException;

public class QuitCommand extends BaseCommand {
    private static final int[] counter = {1};

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        StringBuilder sb = new StringBuilder();

        super.getRepository().getAll().entrySet()
                .stream()
                .sorted((hero1, hero2) -> {
                    long hero1FirstStats = hero1.getValue().getStrength()
                            + hero1.getValue().getAgility()
                            + hero1.getValue().getIntelligence();
                    long hero2FirstStats = hero2.getValue().getStrength()
                            + hero2.getValue().getAgility()
                            + hero2.getValue().getIntelligence();

                    if (Long.compare(hero2FirstStats, hero1FirstStats) == 0) {
                        long hero1SecondStats = hero1.getValue().getHitPoints()
                                + hero1.getValue().getDamage();
                        long hero2SecondStats = hero2.getValue().getHitPoints()
                                + hero2.getValue().getDamage();

                        return Long.compare(hero2SecondStats, hero1SecondStats);
                    }

                    return Long.compare(hero2FirstStats, hero1FirstStats);
                })
                .forEach(hero -> {
                    sb.append(String.format("%d. %s: %s",
                            counter[0]++, hero.getValue().getClass().getSimpleName(), hero.getValue().getName()))
                            .append(System.lineSeparator());
                    sb.append(String.format("###HitPoints: %d", hero.getValue().getHitPoints()))
                            .append(System.lineSeparator());
                    sb.append(String.format("###Damage: %d", hero.getValue().getDamage()))
                            .append(System.lineSeparator());
                    sb.append(String.format("###Strength: %d", hero.getValue().getStrength()))
                            .append(System.lineSeparator());
                    sb.append(String.format("###Agility: %d", hero.getValue().getAgility()))
                            .append(System.lineSeparator());
                    sb.append(String.format("###Intelligence: %d", hero.getValue().getIntelligence()))
                            .append(System.lineSeparator());
                    try {
                        sb.append("###Items: ");
                        if (hero.getValue().getItems().isEmpty()) {
                            sb.append("None").append(System.lineSeparator());
                        } else {
                            for (Item item : hero.getValue().getItems()) {
                                String itemName = item.getName();
                                sb.append(itemName).append(", ");
                            }
                        }
                        sb.setLength(sb.length() - 2);
                        sb.append(System.lineSeparator());
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });

        return sb.toString().trim();
    }
    // 1. Wizard: Jefrey
    // ###HitPoints: 1101
    // ###Damage: 2751
    // ###Strength: 125
    // ###Agility: 125
    // ###Intelligence: 200
    // ###Items: Oculus, Ring
    // 2. Wizard: Donald
    // ###HitPoints: 1100
    // ###Damage: 2750
    // ###Strength: 125
    // ###Agility: 125
    // ###Intelligence: 200
    // ###Items: Oculus

}
