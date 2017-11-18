package foodShortage;

public class Rebel implements Buyer {
    private static final Integer FOOD_INCREASE_VALUE = 5;
    private String name;
    private Integer age;
    private String group;
    private Integer food;

    public Rebel(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    @Override
    public Integer getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += FOOD_INCREASE_VALUE;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
