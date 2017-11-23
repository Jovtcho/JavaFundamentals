package comparableBook;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    public final class LibIterator implements Iterator<Book> {
        int counter;

        public LibIterator() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            if (this.counter < books.length) {
                return true;
            }
            return false;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}
