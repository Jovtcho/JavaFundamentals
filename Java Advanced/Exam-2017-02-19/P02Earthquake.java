import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P02Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(bf.readLine());
        Deque<Deque<Integer>> activities = new ArrayDeque<>();
        Deque<Integer> output = new ArrayDeque<>();

        for (int i = 0; i < count; i++) {
            //Integer[] waves = Arrays.stream(bf.readLine().split("\\s+"))
            //        .map(Integer::valueOf).toArray(Integer[]::new);
            String[] input = bf.readLine().split("\\s+");
            Integer [] waves = new Integer[input.length];
            for (int j = 0; j < input.length; j++) {
                waves[j] = Integer.valueOf(input[j]);
            }

            Deque<Integer> temp = new ArrayDeque<>();
            Collections.addAll(temp, waves);
            activities.addLast(temp);
        }

        StringBuilder sb = new StringBuilder();
        int hit = 0;

        while (!activities.isEmpty()) {
            Deque<Integer> currentActivity = activities.pollFirst();
            int seismicity = currentActivity.pollFirst();

            if (currentActivity.size() >= 1) {
                //sb.append(seismicity);
                //sb.append(" ");
                //hit++;
                output.addLast(seismicity);

                while (!currentActivity.isEmpty()) {
                    if (seismicity >= currentActivity.peek()) {
                        currentActivity.pollFirst();
                    } else {
                        activities.addLast(currentActivity);
                        break;
                    }
                }
            } else {
                //sb.append(seismicity);
                //sb.append(" ");
                //hit++;
                output.addLast(seismicity);
            }
        }

        System.out.println(output.size());
        //System.out.println(hit);
        //System.out.println(sb.toString());
        System.out.println(Arrays.toString(output.toArray()).replaceAll("[\\[\\],]", ""));
    }
}

