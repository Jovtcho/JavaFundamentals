package equalityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (firstPerson.getName().compareTo(secondPerson.getName()) == 0) {
            return Integer.compare(firstPerson.getAge(), (secondPerson.getAge()));
        }
        return firstPerson.getName().compareTo(secondPerson.getName());
    }
}
