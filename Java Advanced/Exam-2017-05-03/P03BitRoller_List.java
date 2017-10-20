import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class P03BitRoller_List {
    final static int BITS = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int pillarPosition = Integer.parseInt(br.readLine());
        int rolls = Integer.parseInt(br.readLine());
        List<Character> num = new LinkedList<>();

        String numToBits = Integer.toBinaryString(n);
        int padLength = BITS - numToBits.length();
        String pad = new String(new char[padLength]).replace('\0', '0');
        String bitsNum = pad.concat(numToBits);

        for (char ch : bitsNum.toCharArray()) {
            num.add(ch);
        }

        char freezeBit = num.get(BITS - 1 - pillarPosition);
        num.remove(BITS - 1 - pillarPosition);
        for (int index = 0; index < rolls; index++) {

            //System.out.println(Arrays.toString(num.toArray()).replaceAll("[\\[\\], ]", ""));
            char tempBit = num.get(BITS - 2);
            num.add(0, tempBit);
            //System.out.println(Arrays.toString(num.toArray()).replaceAll("[\\[\\], ]", ""));
            num.remove(BITS - 1);
            //System.out.println(Arrays.toString(num.toArray()).replaceAll("[\\[\\], ]", ""));

            //System.out.println(Arrays.toString(num.toArray()).replaceAll("[\\[\\], ]", ""));
        }
        num.add(BITS - 1 - pillarPosition, freezeBit);

        StringBuilder sb = new StringBuilder();
        for (Character ch : num) {
            //System.out.print(ch);
            sb.append(ch);
        }
        //System.out.println(sb.toString());
        System.out.println(Integer.parseInt(sb.toString(), 2));
    }
}
