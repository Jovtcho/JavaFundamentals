import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\input.txt";
        String outputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
