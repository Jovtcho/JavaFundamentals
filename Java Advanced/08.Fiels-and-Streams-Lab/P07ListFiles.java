import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Exercises\\JavaAdvanced\\08.Resources\\Files-and-Streams";
        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    continue;
                } else if (file.isFile()) {
                    System.out.println(file.getName() + ": " + file.length());
                }
            }
        } else {
            System.out.println(path + " directory does not exist");
        }
    }
}
