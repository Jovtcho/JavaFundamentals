import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02EncryptSortPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringsCount = Integer.parseInt(scanner.nextLine());
        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            strings[i] = scanner.nextLine();
        }

        int[] encryptedArr = EncryptString(strings);
        Arrays.sort(encryptedArr);

        getPrintArray(encryptedArr);

    }

    public static void getPrintArray(int[] encryptedArr) {
        for (int num : encryptedArr) {
            System.out.println(num);
        }

    }

    public static int[] EncryptString(String[] strings) {
        //char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int[] encryptedArr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String currentString = strings[i];
            int currentStringLength = currentString.length();
            int sum = 0;

            for (char ch : currentString.toCharArray()) {
                boolean isVowelSmall = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
                boolean isVowelCapital = ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

                if (isVowelSmall || isVowelCapital) {
                    sum += ch * currentStringLength;
                } else {
                    sum += ch / currentStringLength;
                }
            }

            encryptedArr[i] = sum;
        }

        return encryptedArr;
    }
}
