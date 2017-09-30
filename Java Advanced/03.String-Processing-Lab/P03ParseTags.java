import java.util.Scanner;

public class P03ParseTags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        String openTag = "<upcase>";
        String closeTag = "</upcase>";

        int openIndex = inputText.indexOf(openTag);
        int closeIndex = inputText.indexOf(closeTag);

        while (openIndex != -1 && closeIndex != -1) {
            String textBetweenTags = inputText.substring(openIndex, closeIndex + closeTag.length());
            int tempCloseIndex = textBetweenTags.indexOf(closeTag);
            String replacementText = textBetweenTags.substring(openTag.length(), tempCloseIndex).toUpperCase();
            inputText = inputText.replace(textBetweenTags, replacementText);

            openIndex = inputText.indexOf(openTag);
            closeIndex = inputText.indexOf(closeTag);
        }

        System.out.println(inputText);
    }
}
