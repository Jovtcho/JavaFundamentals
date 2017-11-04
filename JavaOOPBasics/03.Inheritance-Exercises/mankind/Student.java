package mankind;

public class Student extends Human {
    private String facultyNumber;

    Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        if (5 > facultyNumber.length() || facultyNumber.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Faculty number: ").append(this.getFacultyNumber()).append(System.lineSeparator());
        return sb.toString();
    }
}
