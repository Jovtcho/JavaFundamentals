package genericSwapMethodStrings;

import java.util.List;

public class Box<T> {
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

    @Override
    public String toString() {
        return String.format("%s: %s", this.element.getClass().getCanonicalName(), this.element);
    }
}
