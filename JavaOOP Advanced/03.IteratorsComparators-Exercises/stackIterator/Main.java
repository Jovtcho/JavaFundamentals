package stackIterator;

import stackIterator.implementations.CommandInterpreterImpl;
import stackIterator.interfaces.CommandInterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl();
        Deque<Integer> test = new ArrayDeque<>();

        while (true) {
            String line = br.readLine();
            List<String> tokens = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            commandInterpreter.interpretCommand(tokens);
            if ("END".equalsIgnoreCase(line)) {
                break;
            }
        }
    }
}
