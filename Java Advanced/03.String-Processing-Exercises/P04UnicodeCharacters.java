import java.util.Scanner;

public class P04UnicodeCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <input.length(); i++) {
            int unicode = Character.codePointAt(input, i);
            //int unicode = sb.codePointAt(i);
            sb.append(String.format("\\u%04x", unicode));
        }

        System.out.println(sb.toString());
    }
}
