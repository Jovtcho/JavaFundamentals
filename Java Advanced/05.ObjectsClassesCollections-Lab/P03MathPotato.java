import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P03MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] kids = Arrays.stream(bf.readLine().split("\\s+")).toArray(String[]::new);
        int tossCount = Integer.parseInt(bf.readLine());
        ArrayDeque<String> players = new ArrayDeque<>();


        for (String kid : kids) {
            players.add(kid);
        }

        int cycle = 1;
        while (players.size() > 1) {
            String player = "";

            for (int index = 1; index < tossCount; index++) {
                player = players.poll();
                players.offer(player);
            }

            if (isCyclePrime(cycle)) {
                player = players.peek();
                System.out.println("Prime " + player);
            } else {
                player = players.poll();
                System.out.println("Removed " + player);
            }

            cycle++;
        }

        System.out.println("Last is " + players.peek());
    }

    private static boolean isCyclePrime(int cycle) {
        boolean isPrime = true;

        if (cycle == 1)
        {
            isPrime = false;
            return isPrime;
        }

        for (long i = 2; i <= Math.sqrt(cycle); i++)
        {
            if (cycle % i == 0)
            {
                isPrime = false;
                return isPrime;
            }
        }

        return isPrime;
    }
}
