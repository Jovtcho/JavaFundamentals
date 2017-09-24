import java.util.Scanner;

public class P10XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsInBits = new String[8];

        for (int i = 0; i < 8; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            String numToString = String.format("%32s", Integer.toBinaryString(num)).replace(' ', '0');
            numsInBits[i] = numToString;
        }

        int counter = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 30; j++) {
                String firstXbitNum = numsInBits[i].substring(j, j + 3);
                String secondXbitNum = numsInBits[i + 1].substring(j, j + 3);
                String thirdXbitNum = numsInBits[i + 2].substring(j, j + 3);

                if (firstXbitNum.equals("101") && secondXbitNum.equals("010") && thirdXbitNum.equals("101")) {
                    counter++;
                }
                //System.out.println();
            }
        }

        System.out.printf("%d%n", counter);
    }
}
