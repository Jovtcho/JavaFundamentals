import java.util.Scanner;

public class P9ExtractBitFromInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        //System.out.println(String.format("%16s", Integer.toBinaryString(num)).replace(' ', '0'));

        int pos = scanner.nextInt();
        int mask = 1 << pos;
        //System.out.println(String.format("%16s", Integer.toBinaryString(mask)).replace(' ', '0'));

        int checkNum = num & mask;
        //System.out.println(String.format("%16s", Integer.toBinaryString(checkNum)).replace(' ', '0'));

        System.out.println(checkNum == mask ? 1 : 0);
    }
}
