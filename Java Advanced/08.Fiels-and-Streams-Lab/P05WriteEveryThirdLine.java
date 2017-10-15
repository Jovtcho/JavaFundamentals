import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\input.txt";
        String outputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))) {

            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                if (counter % 3 == 0) {
                    writer.println(line);
                }

                counter++;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
