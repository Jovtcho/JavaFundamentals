import java.util.Scanner;

public class P01CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalText = scanner.nextLine();
        String text = originalText.toLowerCase();
        //String copyText = text;
        String str = scanner.nextLine().toLowerCase();
        int index = text.indexOf(str);
        StringBuilder sb = new StringBuilder(text);
        int counter = 0;

        while (index != -1) {
            counter++;

            sb = sb.deleteCharAt(index);
            text = sb.toString();
            index = text.indexOf(str);
        }

        System.out.println(counter);
    }
}
