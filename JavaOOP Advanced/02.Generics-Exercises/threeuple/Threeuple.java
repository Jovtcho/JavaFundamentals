package threeuple;

public class Threeuple<E, T, V> {
    private E item1;
    private T item2;
    private V item3;

    public Threeuple(E item1, T item2, V item3) {
        this.setItem1(item1);
        this.setItem2(item2);
        this.setItem3(item3);
    }

    private void setItem1(E item1) {
        this.item1 = item1;
    }

    private void setItem2(T item2) {
        this.item2 = item2;
    }

    private void setItem3(V item3) {
        this.item3 = item3;
    }

    private E getItem1() {
        return this.item1;
    }

    private T getItem2() {
        return this.item2;
    }

    private V getItem3() {
        return this.item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.getItem1(), this.getItem2(), this.getItem3());
    }
}
