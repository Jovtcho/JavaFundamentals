package coffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeeList;
    private List<Coin> coins;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void buyCoffee(String size, String type) {
        CoffeeSize coffeeSize = CoffeeSize.valueOf(CoffeeSize.class, size.toUpperCase());
        CoffeeType coffeeType = CoffeeType.valueOf(CoffeeType.class, type.toUpperCase());
        int sumOfCoins = this.coins
                .stream()
                .mapToInt(Coin::getValue)
                .sum();

        if (sumOfCoins >= coffeeSize.getPrice()) {
            Coffee coffee = new Coffee(coffeeType, coffeeSize);
            this.coffeeList.add(coffee);
            this.coins.clear();
        }
    }

    public void insertCoin(String coin) {
        Coin insertedCoin = Coin.valueOf(Coin.class, coin.toUpperCase());
        //int coinValue = insertedCoin.getValue();
        this.coins.add(insertedCoin);
    }

    public Iterable<Coffee> coffeesSold() {
        return this.coffeeList;
    }

}
