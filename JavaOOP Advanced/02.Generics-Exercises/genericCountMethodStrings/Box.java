package genericCountMethodStrings;

import java.util.List;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T element;
    //private List<T> elements;

    public Box(T element) {
        this.element = element;
    }

    public static <T> void swapElements(List<T> list, int firstIndex, int secondIndex) {
        //T tempElement = list.remove(firstIndex);
        list.add(firstIndex, list.get(secondIndex));
        T tempElement = list.remove(firstIndex + 1);
        list.add(secondIndex, tempElement);
        list.remove(secondIndex + 1);
    }

    public static <T extends Comparable<T>> int countGreaterElements(List<T> list, T givenElement) {
        int count = 0;
        for (T elementT : list) {
            if (elementT.compareTo(givenElement) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getCanonicalName(), this.element);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.element.compareTo(o.element);
    }
}
