package animals;

public class Tomcat extends Cat {
    private static final String SOUND = "Give me one million b***h";

    protected Tomcat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setGender(String gender) {
        if (!gender.equalsIgnoreCase(MALE_GENDER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Tomcat.class.getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(produceSound());
        return sb.toString();
    }
}
