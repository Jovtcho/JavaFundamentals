import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = Arrays.stream(scanner.nextLine().split("[ ,.!?]"))
                .filter(s -> (s != null && s.length() > 0)).toArray(String[]::new);

        List<String> palindromes = new ArrayList<>();

        for (String word : text) {
            if (word.length() == 1) {
                palindromes.add(word);
                continue;
            }

            String reversedWord = new StringBuilder(word).reverse().toString();

            if (word.equals(reversedWord)) {
                palindromes.add(word);
            }
        }

        List<String> uniquePalindromes = palindromes.stream().distinct().collect(Collectors.toList());
        uniquePalindromes.sort((p1, p2) -> p1.compareTo(p2));

        System.out.println(Arrays.toString(uniquePalindromes.toArray()));
    }
}
