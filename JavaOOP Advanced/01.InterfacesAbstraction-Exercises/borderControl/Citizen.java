package borderControl;

public class Citizen extends Inhabitant implements Idable {
    private String name;
    private Integer age;

    Citizen(String name, Integer age, String id) {
        super(id);
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }
}
