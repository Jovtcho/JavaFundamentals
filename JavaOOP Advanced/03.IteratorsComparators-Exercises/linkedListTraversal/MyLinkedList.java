package linkedListTraversal;

public interface MyLinkedList<T> extends Iterable<T> {
    void add(T element);

    boolean remove(T element);

    int getSize();
}
