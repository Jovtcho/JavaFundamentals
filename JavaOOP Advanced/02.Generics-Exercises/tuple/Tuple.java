package tuple;

public class Tuple<E, T> {
    private E item1;
    private T item2;

    public Tuple(E item1, T item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    private void setItem1(E item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }

    public E getItem1() {
        return this.item1;
    }

    public T getItem2() {
        return this.item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getItem1(), this.getItem2());
    }
}
