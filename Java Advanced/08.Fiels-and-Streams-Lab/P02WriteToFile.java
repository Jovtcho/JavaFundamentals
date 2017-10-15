import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\input.txt";
        String outputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\output.txt";
        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (!punctuation.contains((char) oneByte)) {
                    fos.write(oneByte);
                }

                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
