import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03WiggleWiggleBitOp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("\\s+");

        for (int i = 0; i < nums.length; i += 2) {
            Long num1 = Long.valueOf(nums[i]);
            Long num2 = Long.valueOf(nums[i + 1]);

            for (int j = 0; j < 64; j += 2) {
                if ((num1 & (1L << j)) == (num2 & (1L << j))) {
                    continue;
                } else {
                    num1 ^= 1L << j;
                    num2 ^= 1L << j;
                }
            }

            num1 = Long.MAX_VALUE + ~num1 + 1;
            num2 = Long.MAX_VALUE + ~num2 + 1;

            String strNum1 = Long.toBinaryString(num1);
            String pad1 = new String(new char[63 - strNum1.length()]).replace('\0', '0');
            strNum1 = pad1 + strNum1;
            String strNum2 = Long.toBinaryString(num2);
            String pad2 = new String(new char[63 - strNum2.length()]).replace('\0', '0');
            strNum2 = pad2 + strNum2;

            System.out.println(num1 + " " + strNum1);
            System.out.println(num2 + " " + strNum2);
        }
    }
}
