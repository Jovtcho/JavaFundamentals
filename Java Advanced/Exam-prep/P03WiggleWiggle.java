import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P03WiggleWiggle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("\\s+");

        // long num1 = 36854775807L;
        // long num2 = 2285477580L;

        for (int i = 0; i < nums.length; i += 2) {
            Long num1 = Long.valueOf(nums[i]);
            Long num2 = Long.valueOf(nums[i + 1]);

            String strNum1 = Long.toBinaryString(num1);
            String pad1 = new String(new char[63 - strNum1.length()]).replace('\0', '0');
            String strNum2 = Long.toBinaryString(num2);
            String pad2 = new String(new char[63 - strNum2.length()]).replace('\0', '0');

            char[] num1Arr = (pad1 + strNum1).toCharArray();
            char[] num2Arr = (pad2 + strNum2).toCharArray();


            for (int index = num1Arr.length - 1; index >= 0; index -= 2) {
                char currentBitNum1 = num1Arr[index];
                char currentBitNum2 = num2Arr[index];

                if (currentBitNum1 != currentBitNum2) {
                    char ch = currentBitNum1;
                    num1Arr[index] = num2Arr[index];
                    num2Arr[index] = ch;
                }
            }

            for (int index = 0; index < num1Arr.length; index++) {
                num1Arr[index] = num1Arr[index] == '0' ? '1' : '0';
            }

            for (int index = 0; index < num2Arr.length; index++) {
                num2Arr[index] = num2Arr[index] == '0' ? '1' : '0';
            }


            strNum1 = new String(num1Arr);
            strNum2 = new String(num2Arr);


            num1 = Long.parseLong(strNum1, 2);
            num2 = Long.parseLong(strNum2, 2);

            System.out.print(num1 + " ");
            System.out.println(strNum1);
            System.out.print(num2 + " ");
            System.out.println(strNum2);
        }
    }
}
