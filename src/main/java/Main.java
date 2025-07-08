import java.util.List;

public class Main {
    public static void main(String[] args) {


        BookStore bookstore = new BookStore();


        Book paperBook = new PaperBook(43, "123", 4, "abdullah", "book a", 2020);
        Book eBook = new EBook("456", "EBook", 2015, 10.0, "Author B", "PDF");
        Book showcaseBook = new ShowcaseBook("789", "Showcase Book", 2005, 0.0, "Author C");

        bookstore.addBook(paperBook);
        bookstore.addBook(eBook);
        bookstore.addBook(showcaseBook);


        try {
            bookstore.addBook(new PaperBook(4, "123", 4, "abdullah", "book a", 2020));
        } catch (IllegalArgumentException e) {
            System.out.println("book store: " + e.getMessage());
        }


        try {
            double amount = bookstore.buyBook("123", 2, "test@email.com", "123 Street");
            System.out.println(" book store: Paid " + amount );
        } catch (Exception e) {
            System.out.println(" book store: " + e.getMessage());
        }


        try {
            bookstore.buyBook("123", 4, "test@email.com", "123 Street");
        } catch (Exception e) {
            System.out.println("Quantum book store: " + e.getMessage());
        }


        try {
            double amount = bookstore.buyBook("456", 1, "ali@email.com", "");
            System.out.println(" book store: Paid " + amount );
        } catch (Exception e) {
            System.out.println("book store: " + e.getMessage());
        }

        //  Showcase book
        try {
            bookstore.buyBook("789", 1, "test@email.com", "123 Street");
        } catch (Exception e) {
            System.out.println("book store: " + e.getMessage());
        }

        // remove outdated books
        List<Book> outdated = bookstore.removeOutdatedBooks(2023, 10);
        System.out.println("book store: Removed " + outdated.size() + " outdated books.");
        for (Book book : outdated) {
            System.out.println(" - " + book.getTitle() + " (" + book.getYear() + ")");
        }
    }
}