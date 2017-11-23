package comparingObjects;

public class PersonImpl implements Person {
    private String name;
    private int age;
    private String town;

    public PersonImpl(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getTown() {
        return this.town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        if (this.getName().compareTo(otherPerson.getName()) == 0) {
            if (this.getAge() == otherPerson.getAge()) {
                return this.getTown().compareTo(otherPerson.getTown());
            }
            return Integer.compare(this.getAge(), otherPerson.getAge());
        }
        return this.getName().compareTo(otherPerson.getName());
    }
}
