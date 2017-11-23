package linkedListTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
    private List<T> myList;

    public MyLinkedListImpl() {
        this.setMyList();
    }

    private void setMyList() {
        this.myList = new ArrayList<>();
    }

    private List<T> getMyList() {
        return Collections.unmodifiableList(this.myList);
    }

    @Override
    public void add(T element) {
        this.myList.add(element);
    }

    @Override
    public boolean remove(T element) {
        int index = this.myList.indexOf(element);
        if (index >= 0) {
            this.myList.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return this.getMyList().size();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }


    public final class MyListIterator implements Iterator<T> {
        private int index;

        private MyListIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < myList.size();
        }

        @Override
        public T next() {
            return myList.get(this.index++);
        }
    }
}
