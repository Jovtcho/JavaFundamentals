import java.util.Arrays;
        import java.util.Scanner;

public class P03TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = Arrays.stream(scanner.nextLine().split(", ")).toArray(String[]::new);
        String text = scanner.nextLine();

        for (String bannedWord : bannedWords) {
            String filter = new String(new char[bannedWord.length()]).replace('\0', '*');
            text = text.replaceAll(bannedWord, filter);
        }

        System.out.println(text);
    }
}
