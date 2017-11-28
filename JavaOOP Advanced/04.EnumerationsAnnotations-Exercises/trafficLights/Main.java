package trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("\\s+");
        List<TrafficLights> lights = new LinkedList<>();

        for (String token : tokens) {
            lights.add(TrafficLights.valueOf(token.toUpperCase()));
        }

        int rollCount = Integer.parseInt(br.readLine());

        for (int index = 0; index < rollCount; index++) {
            StringBuilder sb = new StringBuilder();
            for (TrafficLights light : lights) {
                sb.append(setLight(light)).append(" ");
            }

            System.out.println(sb.toString().trim());
            tokens = sb.toString().split("\\s+");
            lights.clear();
            for (String token : tokens) {
                lights.add(TrafficLights.valueOf(token.toUpperCase()));
            }
        }
    }

    private static TrafficLights setLight(TrafficLights light) {
        if (light.ordinal() == 0) {
            light = TrafficLights.GREEN;
        } else if (light.ordinal() == 1) {
            light = TrafficLights.YELLOW;
        } else if (light.ordinal() == 2) {
            light = TrafficLights.RED;
        }

        return light;
    }
}
