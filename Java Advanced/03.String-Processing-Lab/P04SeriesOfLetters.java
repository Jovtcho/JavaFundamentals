import java.util.Scanner;

public class P04SeriesOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isCharDifferent = true;
        char previousCh = input[0];
        sb.append(previousCh);

        for (int i = 1; i < input.length; i++) {
            char currentCh = input[i];

            if (isCharDifferent) {
                if (previousCh == currentCh) {
                    isCharDifferent = false;
                } else {
                    sb.append(currentCh);
                    previousCh = currentCh;
                }
            } else {
                if (previousCh != currentCh) {
                    isCharDifferent = true;
                    sb.append(currentCh);
                    previousCh = currentCh;
                }
            }
        }

        System.out.println(sb.toString());
    }
}


