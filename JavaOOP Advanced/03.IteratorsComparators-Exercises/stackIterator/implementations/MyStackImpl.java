package stackIterator.implementations;

import stackIterator.interfaces.MyStack;

import java.util.*;
import java.util.function.Consumer;

public class MyStackImpl<T extends Integer> implements MyStack<Integer> {
    private static final int DEFAULT_INDEX_VALUE = 0;

    private List<Integer> stack;
    private Iterator<Integer> currentIterator;

    public MyStackImpl() {
        this.setStack();
    }

    private void setStack() {
        this.stack = new ArrayList<>();
    }

    @Override
    public List<Integer> getStack() {
        return Collections.unmodifiableList(this.stack);
    }

    @Override
    public void push(int... input) {
        for (int index = 0; index < input.length; index++) {
            this.stack.add(input[index]);
        }
    }

    @Override
    public void pop() {
        if (this.getStack().isEmpty()) {
            throw new IllegalStateException("No elements");
        }
        this.stack.remove(this.getStack().size() - 1);
    }

    @Override
    public void forEach(Consumer action) {
        this.currentIterator = new StackIterator();
        action.accept(this.currentIterator.next());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<Integer> {
        private int index;

        StackIterator() {
            this.index = stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public Integer next() {
            return stack.get(index--);
        }
    }
}
