package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buy(Product product) {
        if (this.money >= product.getPrice()) {
            this.money -= product.getPrice();
            this.bagOfProducts.add(product);
        } else {
            throw new IllegalStateException(
                    String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bagOfProducts.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }
        sb.append(String.format("%s - ", this.name));
        for (Product product : this.bagOfProducts) {
            String productName = product.getName();
            sb.append(productName).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() - 1);
        return sb.toString();
    }
}
