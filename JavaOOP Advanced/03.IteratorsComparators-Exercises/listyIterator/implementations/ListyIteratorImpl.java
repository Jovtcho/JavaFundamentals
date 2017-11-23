package listyIterator.implementations;

import listyIterator.interfaces.ListyIterator;

import java.util.*;

public class ListyIteratorImpl implements ListyIterator {
    private static final int DEFAULT_INDEX_VALUE = 0;

    private List<String> items;
    private int currentIndex;

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
}
