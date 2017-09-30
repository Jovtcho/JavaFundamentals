import java.util.Scanner;

public class P02SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNum1 = scanner.nextLine();
        String strNum2 = scanner.nextLine();
        int padLength = Math.max(strNum1.length(), strNum2.length()) - Math.min(strNum1.length(), strNum2.length());
        String pad = new String(new char[padLength]).replace('\0', '0');
        StringBuilder sb = new StringBuilder();

        if (strNum1.length() > strNum2.length()) {
            strNum2 = sb.append(strNum2).insert(0, pad).toString();
        }

        if (strNum2.length() > strNum1.length()) {
            strNum1 = sb.append(strNum1).insert(0, pad).toString();
        }

        int[] arrNum1 = new int[strNum1.length()];
        convertNumStringToIntArray(strNum1, arrNum1);
        int[] arrNum2 = new int[strNum2.length()];
        convertNumStringToIntArray(strNum2, arrNum2);

        int mind = 0;
        sb.setLength(0);

        for (int i = arrNum2.length - 1; i >= 0; i--)
        {
            int sumCurrentDigits = arrNum2[i] + arrNum1[i] + mind;
            int digit = sumCurrentDigits % 10;
            mind = sumCurrentDigits / 10;
            sb.append(digit);
        }

        if (mind > 0)
        {
            sb.append(mind);
        }

        String output = sb.reverse().toString().replaceAll("^0+", "");

        System.out.println(output);
    }

    private static void convertNumStringToIntArray(String strNum, int[] arrNum) {
        for (int i = 0; i < strNum.length(); i++) {
            arrNum[i] = Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
    }
}
