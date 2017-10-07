import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P06SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int commandsCount = Integer.parseInt(bf.readLine());
        //String text = "";
        StringBuilder sb = new StringBuilder();
        Deque<String[]> undoCommands = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] commands = bf.readLine().split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1":
                    String textToAppend = commands[1];
                    sb.append(textToAppend);
                    undoCommands.push(commands);
                    break;
                case "2":
                    int countToDeletion = Integer.parseInt(commands[1]);
                    String textToDeletion = sb.substring(sb.length() - countToDeletion);
                    sb.delete(sb.length() - countToDeletion, sb.length());
                    commands[0] = "2";
                    commands[1] = textToDeletion;
                    undoCommands.push(commands);
                    break;
                case "3":
                    int pos = Integer.parseInt(commands[1]);
                    System.out.println(sb.charAt(pos - 1));
                    break;
                case "4":
                    String[] lastCommand = undoCommands.peek();
                    String undoCommand = lastCommand[0];

                    if ("1".equals(undoCommand)) {
                        int textToUndoAppendLength = lastCommand[1].length();
                        sb.delete(sb.length() - textToUndoAppendLength, sb.length());
                    } else if ("2".equals(undoCommand)) {
                        String textToUndoDeletion = lastCommand[1];
                        sb.append(textToUndoDeletion);
                    } else {
                        System.out.println("No such command!");
                    }

                    undoCommands.pop();
                    break;
                default:
                    System.out.println("No such command!");
                    break;
            }
        }
    }
}
