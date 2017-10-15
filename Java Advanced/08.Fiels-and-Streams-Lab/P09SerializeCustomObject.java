import java.io.*;

public class P09SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "C:\\Exercises\\JavaAdvanced\\08.Resources\\output.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Cube cubeFromFile = (Cube) ois.readObject();
            System.out.println(cubeFromFile.color);
            System.out.println(cubeFromFile.width);
            System.out.println(cubeFromFile.height);
            System.out.println(cubeFromFile.depth);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
