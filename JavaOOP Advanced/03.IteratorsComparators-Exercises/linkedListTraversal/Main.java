package linkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int commandsCount = Integer.parseInt(br.readLine());
        MyLinkedList<Integer> myList = new MyLinkedListImpl<>();

        for (int i = 0; i < commandsCount; i++) {
            interpretCommands(br, myList);
        }

        System.out.println(myList.getSize());
        StringBuilder sb = new StringBuilder();
        for (Integer number : myList) {
            sb.append(number).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void interpretCommands(BufferedReader br, MyLinkedList<Integer> myList) throws IOException {
        String[] tokens = br.readLine().split("\\s+");
        String command = tokens[0];
        int number = Integer.parseInt(tokens[1]);

        switch (command.toLowerCase()) {
            case "add":
                myList.add(number);
                break;
            case "remove":
                myList.remove(number);
                break;
            default:
                System.out.println("No such command.");
        }
    }
}
