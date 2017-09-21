public class P8Lottery {
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                for (int k = j + 1; k <= 10; k++) {
                    String output = "" + i + " " + j + " " + k;
                    System.out.println(output);
                }
            }
        }
    }
}
