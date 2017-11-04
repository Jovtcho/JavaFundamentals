package mankind;

public abstract class Human {
    private static final int MINIMUM_FIRSTNAME_LENGTH = 4;
    private static final int MINIMUM_LASTNAME_LENGTH = 3;

    private String firstName;
    private String lastName;

    Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    private String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (!this.isNameFirstLetterCapital(firstName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (!isNameLongEnough(firstName, MINIMUM_FIRSTNAME_LENGTH)) {
            throw new IllegalArgumentException(
                    String.format("Expected length at least %d symbols!Argument: firstName", MINIMUM_FIRSTNAME_LENGTH));
        }
        this.firstName = firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (!this.isNameFirstLetterCapital(lastName)) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (!isNameLongEnough(lastName, MINIMUM_LASTNAME_LENGTH)) {
            throw new IllegalArgumentException(
                    String.format("Expected length at least %d symbols!Argument: lastName", MINIMUM_LASTNAME_LENGTH));
        }
        this.lastName = lastName;
    }

    private boolean isNameFirstLetterCapital(String item) {
        return !Character.isLowerCase(item.charAt(0));
    }

    private boolean isNameLongEnough(String item, int length) {
        return item.length() >= length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.getFirstName()).append(System.lineSeparator());
        sb.append("Last Name: ").append(this.getLastName()).append(System.lineSeparator());
        return sb.toString();
    }
}
