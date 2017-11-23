package stackIterator.interfaces;

import java.util.List;

public interface MyStack<Integer> extends Iterable<Integer> {
    List<Integer> getStack();

    void push(int... input);

    void pop();
}
