import java.util.Scanner;

public class P10ModifyBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int pos = scanner.nextInt();
        int bit = scanner.nextInt();

        if (bit == 0) {
            int mask = ~(1 << pos);
            //System.out.println(String.format("%16s", Integer.toBinaryString(mask)).replace(' ', '0'));
            int outputNum = num & mask;
            System.out.println(outputNum);
        } else {
            int mask = 1 << pos;
            int outputNum = num | mask;
            System.out.println(outputNum);
        }
    }
}
