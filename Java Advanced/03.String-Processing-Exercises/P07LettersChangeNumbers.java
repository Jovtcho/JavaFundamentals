import java.util.Arrays;
        import java.util.Scanner;

public class P07LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequenceses = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

        double sum = 0.0;

        for (String sequencese : sequenceses) {
            double currentResult = 0.0;
            char firstChar = sequencese.charAt(0);
            char lastChar = sequencese.charAt(sequencese.length() - 1);
            String numStr = sequencese.substring(1, sequencese.length() - 1);
            int num = Integer.parseInt(numStr);

            if (Character.isLowerCase(firstChar)) {
                int charPos = (int) firstChar - 96;
                currentResult = 1.0 * num * charPos;
            } else {
                int charPos = (int) firstChar - 64;
                currentResult = 1.0 * num / charPos;
            }

            if (Character.isLowerCase(lastChar))

            {
                int charPos = (int) lastChar - 96;
                currentResult = currentResult + charPos;
            } else {
                int charPos = (int) lastChar - 64;
                currentResult = currentResult - charPos;
            }

            sum += currentResult;
        }

        System.out.printf("%.2f", sum);
    }
}
