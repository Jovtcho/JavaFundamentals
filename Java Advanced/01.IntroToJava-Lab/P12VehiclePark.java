import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P12VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vehicles = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String line = scanner.nextLine();
        int soldVehicleCount = 0;

        while (true) {
            if (line.equals("End of customers!")) {
                break;
            }

            String[] input = line.split("\\s+");
            char vehicleType = input[0].toLowerCase().charAt(0);
            String seatCount = input[2];
            String requestedVehicle = "" + vehicleType + seatCount;
            int index = vehicles.indexOf(requestedVehicle);

            if (index >= 0) {
                int seats = Integer.parseInt(seatCount);
                int price = vehicleType * seats;

                System.out.printf("Yes, sold for %d$%n", price);
                soldVehicleCount++;

                vehicles.remove(index);
            } else {
                System.out.println("No");
            }

            line = scanner.nextLine();
        }

        System.out.print("Vehicles left: ");
        System.out.println(vehicles.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Vehicles sold: %d", soldVehicleCount);
    }
}
