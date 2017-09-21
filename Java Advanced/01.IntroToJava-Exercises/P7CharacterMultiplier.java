import java.util.Scanner;

public class P7CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();
        scanner.nextLine();

        if (str1.length() < str2.length()) {
            String strTemp = str1;
            str1 = str2;
            str2 = strTemp;
        }

        long sum = 0L;

        for (int i = 0; i < str2.length(); i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            int result = ch1 * ch2;
            sum += result;
        }

        if (str1.length() != str2.length()) {
            String str3 = str1.substring(str2.length());

            for (int i = 0; i < str3.length(); i++) {
                char ch = str3.charAt(i);
                sum += ch;
            }
        }

        System.out.println(sum);
    }
}
