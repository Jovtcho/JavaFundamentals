package animals;

public class Frog extends Animal {
    private static final String SOUND = "Frogggg";

    Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Frog.class.getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(produceSound());
        return sb.toString();
    }
}
