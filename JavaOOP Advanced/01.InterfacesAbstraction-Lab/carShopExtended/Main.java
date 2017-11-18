package carShopExtended;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("Leon", "gary", 110, "Spain", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format("%s is %s color and %d horse power",
                car.getModel(), car.getColor(), car.getHorsePower()));
        System.out.println(car.toString());
    }
}
