package strategyPattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (Integer.compare(firstPerson.getName().length(), secondPerson.getName().length()) == 0) {
            return firstPerson.getName().compareToIgnoreCase(secondPerson.getName());
        }
        return Integer.compare(firstPerson.getName().length(), secondPerson.getName().length());
    }
}
