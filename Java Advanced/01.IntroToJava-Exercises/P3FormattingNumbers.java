import javafx.scene.input.DataFormat;

import java.util.Scanner;

public class P3FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int firstNum = Integer.parseInt(input[0]);
        double secondNum = Double.parseDouble(input[1]);
        double thirdNum = Double.parseDouble(input[2]);

//        String firstNumHex = Integer.toHexString(firstNum);
//        String firstNumBinary = Integer.toBinaryString(firstNum);

//        https://dzone.com/articles/java-string-format-examples
//        Specifying a width:
//        String.format("|%20d|", 93); // prints: |                  93|

//        Left Justify Text
//        String.format("|%-30s|", "Hello World"); // prints: |Hello World |


        System.out.print(String.format("|%-10s", Integer.toHexString(firstNum).toUpperCase()));
        System.out.print(String.format("|%10s", Integer.toBinaryString(firstNum)).replace(' ', '0'));
        System.out.printf("|%10.2f", secondNum);
        System.out.printf("|%-10.3f|", thirdNum);
    }
}
