import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        char previousCh = input[0];
        int state = 0;

        for (int i = 0; i < input.length; i++) {
            char currentCh = input[i];

            switch (state) {
                case 0:  //Initial state;
                    state = 1;
                    previousCh = currentCh;
                    break;
                case 1:
                    sb.append(previousCh);
                    if (previousCh == currentCh) {
                        state = 2;
                    }
                    previousCh = currentCh;
                    break;
                case 2:
                    if (previousCh != currentCh) {
                        state = 1;
                    }
                    previousCh = currentCh;
                    break;
            }
        }

        if (input[input.length - 2] != previousCh) {
            sb.append(input[input.length - 1]);
        }

        System.out.println(sb.toString());
    }
}
