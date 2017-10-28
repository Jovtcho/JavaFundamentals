package catLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> cats = new HashMap<>();

        while (true) {
            String line = br.readLine();
            if ("End".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];
            double catFeature = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (catType) {
                case "Siamese":
                    cat = new Siamese(catName, catType, catFeature);
                    break;
                case "Cymric":
                    cat = new Cymric(catName, catType, catFeature);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catName, catType, catFeature);
                    break;
                default:
                    System.out.println("No such type of cat.");
                    break;
            }

            cats.putIfAbsent(cat.getName(), cat);
        }

        String searchedCat = br.readLine();
        System.out.println(cats.get(searchedCat).toString());
    }
}
