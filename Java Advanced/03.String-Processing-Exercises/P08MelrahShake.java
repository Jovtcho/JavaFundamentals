import java.util.Scanner;

public class P08MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        String pattern = scanner.nextLine();
        int veryFirstIndex = 0;
        int veryLastIndex = 0;

        while (true) {
            veryFirstIndex = inputString.indexOf(pattern);
            veryLastIndex = inputString.lastIndexOf(pattern);

            if ((veryFirstIndex == -1 && veryLastIndex == -1)
                    || veryFirstIndex == veryLastIndex
                    || pattern.length() == 0) {
                System.out.println("No shake.");
                break;
            }

            StringBuilder sb = new StringBuilder();

            inputString = sb.append(inputString).delete(veryFirstIndex, veryFirstIndex + pattern.length()).toString();
            sb.setLength(0);
            inputString = sb.append(inputString).delete(veryLastIndex - pattern.length(), veryLastIndex).toString();
            sb.setLength(0);
            System.out.println("Shaked it.");

            int indexCharForRemove = pattern.length() / 2;
            pattern = sb.append(pattern).deleteCharAt(indexCharForRemove).toString();
        }

        System.out.println(inputString);
    }
}
