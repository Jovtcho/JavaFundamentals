import java.util.Scanner;

public class P02ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  URL -->  https://softuni.bg/courses/java-advanced

        String[] line = scanner.nextLine().split("://");

        if (line.length != 2) {
            System.out.println("Invalid URL");
            return;
        }

        String protocol = line[0];
        String serverAndResources = line[1];
        int index = serverAndResources.indexOf('/');

        if (index < 0) {
            System.out.println("Invalid URL");
            return;
        }

        String server = serverAndResources.substring(0, index);
        String resources = serverAndResources.substring(index + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);

    }
}
