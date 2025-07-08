import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore {
    private  Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        if (inventory.containsKey(book.getISBN())) {
            throw new IllegalArgumentException("Book with ISBN " + book.getISBN() + " alredy exists.");
        }

        inventory.put(book.getISBN(), book);
    }



    public double buyBook(String ISBN, int quantity, String email, String address) throws Exception {
        Book book = inventory.get(ISBN);
        if (book == null) {
            throw new Exception("Book with ISBN " + ISBN + " not found.");
        }
        return book.buy(quantity, email, address);
    }
}
