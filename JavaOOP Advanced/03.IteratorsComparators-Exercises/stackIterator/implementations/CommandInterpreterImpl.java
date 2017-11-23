package stackIterator.implementations;

import stackIterator.interfaces.CommandInterpreter;
import stackIterator.interfaces.MyStack;

import java.util.List;

public class CommandInterpreterImpl implements CommandInterpreter {
    private MyStack<Integer> myStack;

    public CommandInterpreterImpl() {
        this.myStack = new MyStackImpl<>();
    }

    @Override
    public void interpretCommand(List<String> commands) {
        String command = commands.remove(0);

        switch (command.toLowerCase()) {
            case "push":
                int[] elements = getElements(commands);
                this.myStack.push(elements);
                break;
            case "pop":
                try {
                    this.myStack.pop();
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "end":
                for (Integer integer : this.myStack) {
                    System.out.println(integer);
                }
                for (Integer integer : this.myStack) {
                    System.out.println(integer);
                }
                //System.out.println(this.myStack.printTwiceAll());
                break;
        }
    }

    private int[] getElements(List<String> items) {
        int[] elements = new int[items.size()];
        for (int index = 0; index < elements.length; index++) {
            String currentItem = items.get(index).replaceAll(",", "").trim();
            elements[index] = Integer.parseInt(currentItem);
        }

        return elements;
    }
}
