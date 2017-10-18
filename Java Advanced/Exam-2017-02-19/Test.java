import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int mask = 1 << num;

        System.out.println(num);
        System.out.println(mask);
        System.out.println(Integer.MIN_VALUE);


    }
}
