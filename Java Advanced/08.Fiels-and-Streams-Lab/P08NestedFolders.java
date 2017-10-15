import java.io.File;
import java.nio.file.Files;
import java.util.*;

public class P08NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Exercises\\JavaAdvanced\\08.Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> directories = new ArrayDeque<>();
        List<String> allDirNames = new LinkedList<>();

        if (root.exists()) {
            directories.addLast(root);
        } else {
            System.out.println(path + " directory does not exist.");
            return;
        }

        int dirCounter = 0;
        while (!directories.isEmpty()) {
            File currentDir = directories.pollFirst();

            if (currentDir.isDirectory()) {
                allDirNames.add(currentDir.getName());
                dirCounter++;

                for (File dir : currentDir.listFiles()) {
                    if (dir.isDirectory()) {
                        directories.addLast(dir);
                    }
                }
            }
        }

        allDirNames.stream().forEach(d -> System.out.println(d));
        System.out.println(dirCounter + " folders");
    }
}
