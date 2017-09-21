import java.util.Scanner;

public class P6HitTheTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int target = Integer.parseInt(scanner.nextLine());

        if (target < 0) {
            for (int i = 1; i <= 20 + target; i++) {
                System.out.printf("%d - %d = %d%n", i, Math.abs(target - i), target);
            }
            //return;
        } else if (target <= 20) {
            for (int i = 1; i < target; i++) {
                System.out.printf("%d + %d = %d%n", i, target - i, target);
            }
            for (int i = 1; i <= 20 - target; i++) {
                System.out.printf("%d - %d = %d%n", target + i, i, target);
            }
        } else {
            for (int i = target - 20; i <= 20; i++) {
                System.out.printf("%d + %d = %d%n", i, target - i, target);
            }
        }
    }
}

