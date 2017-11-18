package jarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public Deque<T> getElements() {
        return this.elements;
    }

    public void add(T element) {
        this.elements.push(element);
    }

    public T remove() {
        return this.elements.pop();
    }
}
