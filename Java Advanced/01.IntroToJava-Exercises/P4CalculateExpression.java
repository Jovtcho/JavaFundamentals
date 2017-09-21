import java.util.Scanner;

public class P4CalculateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNum = scanner.nextDouble();
        double secondNum = scanner.nextDouble();
        double thirdNum = scanner.nextDouble();
        scanner.nextLine();

        double powerFunc1 = (firstNum + secondNum + thirdNum) / Math.sqrt(thirdNum);
        double baseFunc1 = (firstNum * firstNum + secondNum * secondNum) / (firstNum * firstNum - secondNum * secondNum);
        double func1 = Math.pow(baseFunc1, powerFunc1);

        double func2 = Math.pow(firstNum * firstNum + secondNum * secondNum - Math.pow(thirdNum, 3), firstNum - secondNum);

        double avgThreeNums = (firstNum + secondNum + thirdNum) / 3;
        double avgTwoFuncs = (func1 + func2) / 2;

        double diff = Math.abs(avgThreeNums - avgTwoFuncs);

        System.out.printf("F1 result: %.2f; ", func1);
        System.out.printf("F2 result: %.2f; ", func2);
        System.out.printf("Diff: %.2f", diff);
    }
}
