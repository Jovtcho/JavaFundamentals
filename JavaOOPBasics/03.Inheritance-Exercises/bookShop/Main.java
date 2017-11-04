package bookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String author = br.readLine();
        String title = br.readLine();
        double price = Double.parseDouble(br.readLine());

        Book book = null;
        GoldenEditionBook goldenBook = null;
        try {
            book = new Book(author, title, price);
            goldenBook = new GoldenEditionBook(author, title, price);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return;
        }

        System.out.println(book.toString());
        System.out.println(goldenBook.toString());
    }
}
