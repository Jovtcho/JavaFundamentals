package stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        setData();
    }

    private void setData() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        if (!this.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        return "Stack is empty";
    }

    public String peek() {
        if (!this.isEmpty()) {
            return this.data.get(this.data.size() - 1);
        }
        return "Stack is empty";
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

}