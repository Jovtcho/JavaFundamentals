package collection.implementations;

import collection.interfaces.CommandInterpreter;

import java.util.List;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static ListyIteratorImpl myListyIterator;

    public CommandInterpreterImpl() {
    }

    @Override
    public void interpretCommand(List<String> commands) {
        String command = commands.remove(0);

        switch (command.toLowerCase()) {
            case "create":
                String[] elements = getElements(commands);
                myListyIterator = new ListyIteratorImpl(elements);
                break;
            case "move":
                System.out.println(myListyIterator.move());
                break;
            case "print":
                try {
                    System.out.println(myListyIterator.print());
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
            case "hasnext":
                System.out.println(myListyIterator.hasNext());
                break;
            case "printall":
                try {
                    System.out.println(myListyIterator.printAll());
                } catch (IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
                break;
        }
    }

    private String[] getElements(List<String> items) {
        String[] elements = new String[items.size()];
        for (int index = 0; index < elements.length; index++) {
            elements[index] = items.get(index);
        }

        return elements;
    }
}
