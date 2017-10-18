import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxCapacity = Integer.parseInt(br.readLine());

        Deque<String> bunkers = new ArrayDeque<>();
        Deque<Integer> weapons = new ArrayDeque<>();
        int freeCapacity = maxCapacity;

        String regex = "[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);

        String input = br.readLine();

        while (!"Bunker Revision".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");

            for (String item : tokens) {
                Matcher matcher = pattern.matcher(item);

                if (matcher.find()) {
                    bunkers.add(item);
                } else {
                    int weaponCapacity = Integer.parseInt(item);

                    boolean weaponContained = false;
                    while (bunkers.size() > 1) {
                        if (freeCapacity >= weaponCapacity) {
                            weapons.add(weaponCapacity);
                            freeCapacity -= weaponCapacity;
                            weaponContained = true;
                            break;
                        }

                        if (weapons.size() == 0) {
                            System.out.printf("%s -> Empty%n", bunkers.peek());
                        } else {
                            System.out.printf("%s -> ", bunkers.peek());
                            System.out.println(Arrays.toString(weapons.toArray()).replaceAll("[\\[\\]]", ""));
                        }

                        bunkers.remove();
                        weapons.clear();
                        freeCapacity = maxCapacity;
                    }

                    if (!weaponContained && bunkers.size() == 1) {
                        if (maxCapacity >= weaponCapacity) {
                            if (freeCapacity < weaponCapacity) {
                                while (freeCapacity < weaponCapacity) {
                                    int removedWeapon = weapons.remove();
                                    freeCapacity += removedWeapon;
                                }
                            }

                            weapons.add(weaponCapacity);
                            freeCapacity -= weaponCapacity;
                        }
                    }
                }

            }

            input = br.readLine();
        }
    }
}


