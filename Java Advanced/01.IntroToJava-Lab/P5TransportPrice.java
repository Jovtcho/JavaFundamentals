import java.util.Scanner;

public class P5TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double taxiInitialTax = 0.7;
        double taxiDayCostPerKm = 0.79;
        double taxiNightCostPerKm = 0.9;
        double busCostPerKm = 0.09;
        double trainCostPerKm = 0.06;

        double distance = Double.parseDouble(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double tripPrice = 0.0;

        if (distance < 20) {
            if (timeOfDay.equals("day")) {
                tripPrice = distance * taxiDayCostPerKm;
            } else {
                tripPrice = distance * taxiNightCostPerKm;
            }

            tripPrice += taxiInitialTax;
        } else if (distance < 100) {
            tripPrice = distance * busCostPerKm;
        } else {
            tripPrice = distance * trainCostPerKm;
        }

        System.out.printf("%.2f", tripPrice);
    }
}
