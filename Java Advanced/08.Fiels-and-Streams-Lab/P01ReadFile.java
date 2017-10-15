import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\input.txt";

        try (FileInputStream fis = new FileInputStream(inputPath)) {
            int oneByte = fis.read();

            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
