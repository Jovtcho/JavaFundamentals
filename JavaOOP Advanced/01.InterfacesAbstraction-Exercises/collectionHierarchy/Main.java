package collectionHierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] elements = br.readLine().split("\\s+");
        int removeCount = Integer.parseInt(br.readLine());

        AddCollection addCollection = new AddCollectionImpl();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollectionImpl();
        MyList myList = new MyListImpl();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();

        for (String element : elements) {
            sb1.append(addCollection.addElement(element)).append(" ");
            sb2.append(addRemoveCollection.addElement(element)).append(" ");
            sb3.append(myList.addElement(element)).append(" ");

        }

        for (int i = 0; i < removeCount; i++) {
            sb4.append(addRemoveCollection.remove()).append(" ");
            sb5.append(myList.remove()).append(" ");
        }

        System.out.println(sb1.toString().trim());
        System.out.println(sb2.toString().trim());
        System.out.println(sb3.toString().trim());
        System.out.println(sb4.toString().trim());
        System.out.println(sb5.toString().trim());
    }
}
