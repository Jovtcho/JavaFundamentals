package birthdayCelebrations;

public class Citizen extends Inhabitant implements Idable, Birthdayable {
    private String name;
    private Integer age;
    private String birthdate;

    Citizen(String name, Integer age, String id, String birthdate) {
        super(id);
        this.setName(name);
        this.setAge(age);
        this.setBirthdate(birthdate);
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
}
