import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P04CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //{regionName} -> {meteorType} -> {count}

        Map<String, TreeMap<String, Long>> regions = new TreeMap<>();

        while (true) {
            String line = br.readLine();
            if ("Count em all".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split(" -> ");
            String regionName = tokens[0];
            String meteorType = tokens[1];
            long count = Long.valueOf(tokens[2]);

            if (!regions.containsKey(regionName)) {
                TreeMap<String, Long> meteorTypeCount = new TreeMap<>();
                meteorTypeCount.put("Black", 0L);
                meteorTypeCount.put("Red", 0L);
                meteorTypeCount.put("Green", 0L);
                regions.put(regionName, meteorTypeCount);
            }
//            regions.putIfAbsent(regionName, meteorTypeCount);


            long currentCount = regions.get(regionName).get(meteorType) + count;
            TreeMap<String, Long> currentMeteorType = regions.get(regionName);
            currentMeteorType.put(meteorType, currentCount);
            regions.put(regionName, currentMeteorType);

            if (regions.get(regionName).get("Green") >= 1000000) {
                regions.get(regionName).put("Red", regions.get(regionName).get("Red") + regions.get(regionName).get("Green") / 1000000);
                regions.get(regionName).put("Green", regions.get(regionName).get("Green") % 1000000);
            }

            if (regions.get(regionName).get("Red") >= 1000000) {
                regions.get(regionName).put("Black", regions.get(regionName).get("Black") + regions.get(regionName).get("Red") / 1000000);
                regions.get(regionName).put("Red", regions.get(regionName).get("Red") % 1000000);
            }
        }

        regions.entrySet().stream()
                .sorted((r1, r2) -> {
                    Long valueBlackFromRegion1 = r1.getValue().entrySet().stream()
                            .filter(m -> "Black".equalsIgnoreCase(m.getKey())).findFirst().get().getValue();
                    Long valueBlackFromRegion2 = r2.getValue().entrySet().stream()
                            .filter(m -> "Black".equalsIgnoreCase(m.getKey())).findFirst().get().getValue();

                    if (Long.compare(valueBlackFromRegion2, valueBlackFromRegion1) == 0) {
                        int nameR1Length = r1.getKey().length();
                        int nameR2Length = r2.getKey().length();

                        return Integer.compare(nameR1Length, nameR2Length);
                    }

                    return Long.compare(valueBlackFromRegion2, valueBlackFromRegion1);
                }).forEach(r -> {
            System.out.println(r.getKey());
            r.getValue().entrySet().stream()
                    .sorted((m1, m2) -> Long.compare(m2.getValue(), m1.getValue()))
                    .forEach(m -> System.out.printf("-> %s : %d%n", m.getKey(), m.getValue()));
        });
    }
}
