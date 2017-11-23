package comparingObjects;

public interface Person extends Comparable<Person> {

    String getName();

    int getAge();

    String getTown();
}
