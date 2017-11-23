package collection.implementations;

import collection.interfaces.ListyIterator;

import java.util.*;
import java.util.function.Consumer;

public class ListyIteratorImpl implements ListyIterator, Iterable {
    private static final int DEFAULT_INDEX_VALUE = 0;

    private List<String> items;
    private int currentIndex;
    private Iterator<String> currentIterator;

    public ListyIteratorImpl(String... items) {
        this.setItems(items);
        this.setCurrentIndex(DEFAULT_INDEX_VALUE);
    }

    private void setItems(String... items) {
        this.items = Arrays.asList(items);
    }

    private void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(this.items);
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    @Override
    public boolean move() {
        if (!this.getItems().isEmpty() && this.getCurrentIndex() < this.getItems().size() - 1) {
            this.setCurrentIndex(this.getCurrentIndex() + 1);
            return true;
        }
        return false;
    }

    @Override
    public String print() {
        if (this.getItems().isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        return this.getItems().get(this.getCurrentIndex());
    }

    @Override
    public boolean hasNext() {
        return this.getCurrentIndex() < this.getItems().size() - 1;
    }

    @Override
    public String printAll() {
        if (this.getItems().isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }

        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(item).append(" ");
        }

        return sb.toString().trim();
    }

    @Override
    public Iterator iterator() {
        return new myIterator();
    }

 //  @Override
 //  public void forEach(Consumer action) {
 //      this.currentIterator = new myIterator();
 //      action.accept(this.currentIterator.next());
 //  }

    private final class myIterator implements Iterator<String> {
        private int index;

        myIterator() {
            this.index = DEFAULT_INDEX_VALUE;
        }

        @Override
        public boolean hasNext() {
            return this.index < items.size();
        }

        @Override
        public String next() {
            return items.get(this.index++);
        }
    }
}
