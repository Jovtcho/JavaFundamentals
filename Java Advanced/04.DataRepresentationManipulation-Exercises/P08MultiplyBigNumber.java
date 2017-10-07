import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P08MultiplyBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine().replaceAll("^[" + 0 + "]+", "");
        String str2 = bf.readLine().replaceAll("^[" + 0 + "]+", "");

        if ("".equals(str1) || "".equals(str2)) {
            System.out.println(0);
            return;
        }

        int[] num1Array = new int[str1.length()];

        for (int i = 0; i < str1.length(); i++) {
            num1Array[i] = Integer.parseInt(String.valueOf(str1.charAt(i)));
        }
        int num2 = Integer.valueOf(str2);

        int mind = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = num1Array.length - 1; i >= 0; i--) {
            int multiCurrentDigits = num1Array[i] * num2 + mind;
            int digit = multiCurrentDigits % 10;
            mind = multiCurrentDigits / 10;
            sb.append(digit);
        }

        if (mind > 0) {
            sb.append(mind);
        }

        String sbStr = sb.reverse().toString().replaceAll("^[" + 0 + "]+", "");
        System.out.println(sbStr);
    }
}
