import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {
        String inputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\input.txt";
        String outputPath = "C:\\Exercises\\JavaAdvanced\\08.Resources\\output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {
                if (oneByte == ' ' || oneByte == '\n') {
                    fos.write(oneByte);
                } else {
                    String oneByteString = String.valueOf(oneByte);
                    for (char ch : oneByteString.toCharArray()) {
                        System.out.println(ch);
                        fos.write(ch);
                    }
                }

                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
