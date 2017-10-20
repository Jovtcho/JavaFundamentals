import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Wig dolnite komentari za podregdaneto
        // Map<String, TreeMap<String, Long>> regions = new TreeMap<>();

        // S dwojno srawnenie w strijma
        Map<String, HashMap<String, Long>> regions = new HashMap<>();

        // Tozi regeks e gre[en, zashoto nqma nachalo ^ i kraj na stringa $
        //String regex = "Grow (?<region><[A-Z][a-z]+>) (?<color><[A-Za-z0-9]+>) (?<amount>\\d+)";

        String regex = "^Grow (?<region><[A-Z][a-z]+>) (?<color><[A-Za-z0-9]+>) (?<amount>\\d+)$";
        Pattern pattern = Pattern.compile(regex);

        while (true) {
            String line = br.readLine();
            if ("Icarus, Ignite!".equalsIgnoreCase(line)) {
                break;
            }

            Matcher matcher = pattern.matcher(line);
            if (!matcher.find()) {
                continue;
            }

            String region = matcher.group("region").substring(1, matcher.group("region").length() - 1);
            String color = matcher.group("color").substring(1, matcher.group("color").length() - 1);
            long amount = Long.valueOf(matcher.group("amount"));

            regions.putIfAbsent(region, new HashMap<>());
            regions.get(region).putIfAbsent(color, 0L);

            regions.get(region).put(color, regions.get(region).get(color) + amount);
        }

        // Podredbata na wynshnia Map e po sumata na wsicki Longowe na wytreshnite Map-we w namalqwash red
        // i posle alfabetikali w narstwasht red, ako Longowete sa ednakwi.
        // Wytreshnite Mapowe se podregdat po stojnost na longowte w narastwasht red, i ako te sa ednakwi
        // alfabetikali syshto w narastwasht red.
        //
        // Za da si spestq wtorata podredba Map-owete , alfabetikali, sym naprawil Mapo-wete TreeMap.

        //regions.entrySet().stream()
        //        .sorted((r1, r2) -> Long.compare(
        //                r2.getValue().values().stream().mapToLong(m -> m).sum(),
        //                r1.getValue().values().stream().mapToLong(m -> m).sum()))
        //        .forEach(r -> {
        //            System.out.println(r.getKey());
        //            r.getValue().entrySet().stream()
        //                    .sorted((c1, c2) -> Long.compare(c1.getValue(), c2.getValue()))
        //                    .forEach(c -> {
        //                        System.out.printf("*--%s | %d%n", c.getKey(), c.getValue());
        //                    });
        //        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////

        //Tuk se polzwat HashMap-owe i se izwyrshwa podredba po gorniq nachin chrez komparatori

        regions.entrySet().stream().sorted((region1, region2) -> {
            long totalAmount1 = region1.getValue().values().stream().mapToLong(e -> e).sum();
            long totalAmount2 = region2.getValue().values().stream().mapToLong(e -> e).sum();

            if (totalAmount1 == totalAmount2) {
                return region1.getKey().compareTo(region2.getKey());
            }
            return Long.compare(totalAmount2, totalAmount1);
        }).forEach(region -> {
            System.out.println(region.getKey());

            region.getValue().entrySet().stream().sorted((color1, color2) -> {
                if (Long.compare(color1.getValue(), color2.getValue()) == 0) {
                    return color1.getKey().compareTo(color2.getKey());
                }
                return Long.compare(color1.getValue(), color2.getValue());
            }).forEach(color -> {
                System.out.println("*--" + color.getKey() + " | " + color.getValue());
            });
        });
    }
}
