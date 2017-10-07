import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P04TruckTour {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int pumpCount = Integer.valueOf(bf.readLine());
        Deque<String> allPumps = new ArrayDeque();

        for (int i = 0; i < pumpCount; i++) {
            allPumps.addLast(bf.readLine());
        }

        int index = 0;


        while (true) {
            long fuel = 0L;
            boolean isFuelEnough = true;

            for (String pump : allPumps) {
                String[] currentPump = pump.split("\\s+");
                long currentFuel = Long.valueOf(currentPump[0]);
                long currentDistance = Long.valueOf(currentPump[1]);
                fuel += currentFuel;

                if (fuel >= currentDistance) {
                    fuel -= currentDistance;
                    continue;
                }

                isFuelEnough = false;
                break;
            }

            if (isFuelEnough) {
                System.out.println(index);
                break;
            }

            String pump = allPumps.poll();
            allPumps.addLast(pump);
            index++;
        }
    }
}

