import java.util.*;
import java.util.stream.Collectors;

public class P06MagicExchangeableWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);

        boolean isExchangeable = CheckWordsIsMagicExchangeable(inputLine);

        if (isExchangeable) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean CheckWordsIsMagicExchangeable(String[] inputLine) {
        String firstStr = "";
        String secondStr = "";
        String diff = "";
        Map<Character, Character> firstDict = new LinkedHashMap<>();
        //List<Character> diff = new ArrayList<>();


        if (inputLine[0].length() <= inputLine[1].length()) {
            firstStr = inputLine[0];
            secondStr = inputLine[1];
            diff = secondStr.substring(firstStr.length());
            //diff = secondStr.substring(firstStr.length()).chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        } else {
            firstStr = inputLine[1];
            secondStr = inputLine[0];
            diff = secondStr.substring(firstStr.length());
            //diff = secondStr.substring(firstStr.length()).chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        }

        for (int i = 0; i < firstStr.length(); i++) {
            if (!firstDict.containsKey(firstStr.charAt(i))) {
                if (firstDict.containsValue(secondStr.charAt(i))) {
                    //Console.WriteLine("false");
                    return false;
                }

                firstDict.put(firstStr.charAt(i), secondStr.charAt(i));
            } else {
                if (firstDict.get(firstStr.charAt(i)) == secondStr.charAt(i)) {
                    continue;
                } else {
                    //Console.WriteLine("false");
                    return false;
                }
            }
        }

        for (char ch : diff.toCharArray()) {
            if (!firstDict.containsValue(ch)) {
                //Console.WriteLine("false");
                return false;
            }
        }

        return true;
    }
}
