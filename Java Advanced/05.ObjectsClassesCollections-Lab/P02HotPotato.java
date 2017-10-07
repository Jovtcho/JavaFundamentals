import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayDeque;
        import java.util.Arrays;

public class P02HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] kids = Arrays.stream(bf.readLine().split("\\s+")).toArray(String[]::new);
        int tossCount = Integer.parseInt(bf.readLine());
        ArrayDeque<String> players = new ArrayDeque<>();

        //for (int index = kids.length - 1; index >= 0; index--) {
        for (String kid : kids) {
            players.add(kid);
        }

        while (players.size() > 1) {
            String player = "";

            for (int index = 1; index < tossCount; index++) {
                player = players.poll();
                players.offer(player);
            }

            player = players.poll();
            System.out.println("Removed " + player);
        }

        System.out.println("Last is " + players.peek());
    }
}
