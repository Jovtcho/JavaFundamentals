import java.util.Scanner;

public class P1ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        String str3 = scanner.next();
        scanner.nextLine();

        int num = num1 + num2 + num3;

        System.out.println(str1 + " " + str2 + " " + str3 + " " + num);
    }
}
