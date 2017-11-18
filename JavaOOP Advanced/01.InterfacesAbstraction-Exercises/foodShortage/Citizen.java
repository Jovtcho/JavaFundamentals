package foodShortage;

public class Citizen extends Inhabitant implements Idable, Birthdayable, Buyer {
    private static final Integer FOOD_INCREASE_VALUE = 10;

    private String name;
    private Integer age;
    private String birthdate;
    private Integer food;

    Citizen(String name, Integer age, String id, String birthdate) {
        super(id);
        this.setName(name);
        this.setAge(age);
        this.setBirthdate(birthdate);
        this.food = 0;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String getBirthdate() {
        return this.birthdate;
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
