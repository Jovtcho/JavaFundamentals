package genericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> strScale = new Scale<>("ab", "a");
        Scale<Integer> intScale = new Scale<>(7, 7);

        System.out.println(strScale.getHeavier());
        System.out.println(intScale.getHeavier());
    }
}
