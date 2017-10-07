import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P04ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> carsAtParking = new HashSet<>();

        while (true) {
            String line = bf.readLine();

            if ("END".equalsIgnoreCase(line)) {
                break;
            }
            String[] input = Arrays.stream(line.split(",\\s+")).toArray(String[]::new);
            String command = input[0];
            String carNumber = input[1];

            if ("IN".equalsIgnoreCase(command)) {
                carsAtParking.add(carNumber);
            } else if ("OUT".equalsIgnoreCase(command)) {
                if (!carsAtParking.contains(carNumber)) {
                    continue;
                }

                carsAtParking.remove(carNumber);
            } else {
                System.out.println("No such command!");
            }
        }

        if (carsAtParking.size() ==0){
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String car : carsAtParking) {
            System.out.println(car);
        }
    }
}
