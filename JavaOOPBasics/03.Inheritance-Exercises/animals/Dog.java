package animals;

public class Dog extends Animal {
    private static final String SOUND = "BauBau";

    Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Dog.class.getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(produceSound());
        return sb.toString();
    }
}
