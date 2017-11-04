package animals;

public class Animal {
    //name, age, gender
    protected static final String MALE_GENDER = "Male";
    protected static final String FEMALE_GENDER = "Female";
    private static final String SOUND = "Not implemented!";
    private String name;
    private int age;
    private String gender;

    Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
        }
        this.name = name;
    }

    int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
        }
        this.age = age;
    }

    String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if (gender.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
        }
       // if (!gender.equalsIgnoreCase(MALE_GENDER) && !gender.equalsIgnoreCase(FEMALE_GENDER)) {
       //     throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT);
       // }
        this.gender = gender;
    }

    public String produceSound() {
        return SOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Animal.class.getSimpleName()).append(System.lineSeparator());
        sb.append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender()).append(System.lineSeparator())
                .append(this.produceSound());
        return sb.toString();
    }
}
