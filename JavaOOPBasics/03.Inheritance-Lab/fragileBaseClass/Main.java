package fragileBaseClass;

public class Main {
    public static void main(String[] args) {
        Predator predator = new Predator();
        Food food = new Food();
        predator.eat(food);
        predator.eat(food);
    }
}
