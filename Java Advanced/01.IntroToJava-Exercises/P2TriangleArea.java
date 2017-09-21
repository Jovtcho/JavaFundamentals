import java.util.Scanner;

public class P2TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pointA = scanner.nextLine().split("\\s+");
        String[] pointB = scanner.nextLine().split("\\s+");
        String[] pointC = scanner.nextLine().split("\\s+");

        int pointAx = Integer.parseInt(pointA[0]);
        int pointAy = Integer.parseInt(pointA[1]);

        int pointBx = Integer.parseInt(pointB[0]);
        int pointBy = Integer.parseInt(pointB[1]);

        int pointCx = Integer.parseInt(pointC[0]);
        int pointCy = Integer.parseInt(pointC[1]);

        double result = (pointAx * (pointBy - pointCy) + pointBx * (pointCy - pointAy) + pointCx * (pointAy - pointBy)) / 2;
        int triangleArea = (int) Math.abs(result);

        System.out.println(triangleArea);
    }
}
