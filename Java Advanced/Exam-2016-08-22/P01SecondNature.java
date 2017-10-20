import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P01SecondNature {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> flowers = new ArrayDeque<>(); //queue
        Deque<Integer> buckets = new ArrayDeque<>(); //stack;
        Deque<Integer> secondNature = new ArrayDeque<>(); //queue

        String[] tokens = br.readLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            flowers.add(Integer.parseInt(tokens[i]));
        }

        tokens = br.readLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            buckets.push(Integer.parseInt(tokens[i]));
        }

        while (!flowers.isEmpty() && !buckets.isEmpty()) {
            int currentBucket = buckets.pop();
            int currentFlower = flowers.poll();
            int diff = currentBucket - currentFlower;

            if (diff == 0) {
                secondNature.add(currentBucket);
            } else if (diff > 0) {
                if (!buckets.isEmpty()) {
                    int nextBucket = buckets.pop();
                    nextBucket += diff;
                    buckets.push(nextBucket);
                } else {
                    buckets.push(diff);
                }
            } else {
                currentFlower = Math.abs(diff);
                flowers.addFirst(currentFlower);   //// zapiswam w opashkata naj-otpred, a ne dobawqm naj-otzad
            }
        }

        if (!buckets.isEmpty()) {
            System.out.println(Arrays.toString(buckets.toArray()).replaceAll("[\\[\\],]", ""));
        }

        if (!flowers.isEmpty()) {
            System.out.println(Arrays.toString(flowers.toArray()).replaceAll("[\\[\\],]", ""));
        }

        System.out.println(!secondNature.isEmpty()
                ? Arrays.toString(secondNature.toArray()).replaceAll("[\\[\\],]", "")
                : "None");

    }
}
