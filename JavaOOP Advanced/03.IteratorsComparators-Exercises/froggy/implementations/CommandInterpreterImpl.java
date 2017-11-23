package froggy.implementations;

import froggy.interfaces.CommandInterpreter;
import froggy.interfaces.Lake;

import java.util.List;

public class CommandInterpreterImpl implements CommandInterpreter {
    private Lake<Integer> lake;

    public CommandInterpreterImpl() {
    }

    @Override
    public void interpretCommand(List<String> commands) {

        if ("END".equalsIgnoreCase(commands.get(0))) {
            StringBuilder sb = new StringBuilder();
            for (Integer frogJump : lake) {
                sb.append(frogJump).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
            System.out.println(sb.toString());
        } else {
            Integer[] elements = getElements(commands);
            this.lake = new LakeImpl<>(elements);
        }
    }

    private Integer[] getElements(List<String> items) {
        items.removeIf(item -> (item == null || item.isEmpty()));
        Integer[] elements = new Integer[items.size()];
        for (int index = 0; index < elements.length; index++) {
            String currentItem = items.get(index);
            elements[index] = Integer.parseInt(currentItem);
        }

        return elements;
    }
}
