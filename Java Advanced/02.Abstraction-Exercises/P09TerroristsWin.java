import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> allBombs = new ArrayList<String>();

        getAllBombs(input, allBombs);

        for (String bomb : allBombs) {
            String clearBomb = bomb.substring(1, bomb.length() - 1);
            int bombPower = getBombPower(clearBomb);

            int bombIndex = input.indexOf(bomb);
            int startIndex = Math.max(0, bombIndex - bombPower);
            int endIndex = Math.min(bombIndex + bomb.length() + bombPower, input.length());
            String strForRemove = input.substring(startIndex, endIndex);
            String replacementStr = new String(new char[strForRemove.length()]).replace('\0', '.');
            input = input.replace(strForRemove, replacementStr);
        }

        System.out.println(input);
    }

    private static int getBombPower(String clearBomb) {
        int bombPower = 0;
        for (char ch : clearBomb.toCharArray()) {
            bombPower += ch;
        }

        bombPower = bombPower % 10;
        return bombPower;
    }

    private static void getAllBombs(String input, List<String> allBombs) {
        String regex = "\\|.*?\\|";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            allBombs.add(matcher.group());
        }
    }
}
