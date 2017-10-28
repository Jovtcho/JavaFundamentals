package shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String line = br.readLine();
        String[] peopleTokens = line.split(";");
        for (String peopleToken : peopleTokens) {
            String[] tokens = peopleToken.split("=");
            String name = tokens[0];
            double money = Double.parseDouble(tokens[1]);

            Person person = null;
            try {
                person = new Person(name, money);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }

            people.putIfAbsent(person.getName(), person);
        }

        line = br.readLine();
        String[] productTokens = line.split(";");
        for (String productToken : productTokens) {
            String[] tokens = productToken.split("=");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            Product product = null;
            try {
                product = new Product(name, price);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }

            products.putIfAbsent(product.getName(), product);
        }

        //System.out.println();

        while (true) {
            line = br.readLine();
            if ("END".equalsIgnoreCase(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            Product currentProduct = products.get(productName);
            try {
                people.get(personName).buy(currentProduct);
                System.out.printf("%s bought %s%n", people.get(personName).getName(), currentProduct.getName());
            } catch (IllegalStateException ise) {
                System.out.println(ise.getMessage());
            }
        }

        for (Person person : people.values()) {
            String name = person.getName();
            System.out.println(person.toString());
        }
    }
}
