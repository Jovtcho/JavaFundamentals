package customList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int indexFirst, int indexSecond) {
        T tempElement = this.elements.get(indexFirst);
        this.elements.set(indexFirst, this.elements.get(indexSecond));
        this.elements.set(indexSecond, tempElement);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T el : this.elements) {
            if (el.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.elements.get(0);
        for (int index = 1; index < this.elements.size(); index++) {
            if (this.elements.get(index).compareTo(max) > 0) {
                max = this.elements.get(index);
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.elements.get(0);
        for (int index = 1; index < this.elements.size(); index++) {
            if (this.elements.get(index).compareTo(min) < 0) {
                min = this.elements.get(index);
            }
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
