import java.util.*;

class RandomBookGenerator {
    private static final Random random = new Random();
    private static final String[] TITLES = {
            "great wall", "the long time", "temp1", "temp2",
            "tem3", "fds", "fdkja"
    };
    private static final String[] AUTHORS = {
            "abdullah", "khaled", "hany",
            "ali", "Ramy", "ayman"
    };
    private static final String[] FILETYPES = {"PDF", "word", "txt"};
    private static final int MIN_YEAR = 1990;
    private static final int MAX_YEAR = 2025;
    private static final double MIN_PRICE = 5.0;
    private static final double MAX_PRICE = 50.0;
    private static final int MIN_STOCK = 1;
    private static final int MAX_STOCK = 100;

    public static void addRandomBooks(BookStore bookstore, int count) {
        for (int i = 0; i < count; i++) {
            try {
                Book book = generateRandomBook();
                bookstore.addBook(book);
                System.out.println(" book store: Added book: " + book.getTitle() + " (" + book.getISBN() + ")");
            } catch (IllegalArgumentException e) {
                System.out.println("book store: Skipped duplicate book: " + e.getMessage());
            }
        }
    }

    private static Book generateRandomBook() {
        String ISBN = UUID.randomUUID().toString().substring(0, 8);
        String title = TITLES[random.nextInt(TITLES.length)];
        String author = AUTHORS[random.nextInt(AUTHORS.length)];
        int year = MIN_YEAR + random.nextInt(MAX_YEAR - MIN_YEAR + 1);
        double price = (MAX_PRICE - MIN_PRICE) * random.nextDouble();

        int bookType = random.nextInt(3);
        switch (bookType) {
            case 0:
                int stock = MIN_STOCK + random.nextInt(MAX_STOCK - MIN_STOCK + 1);
                return new PaperBook(stock,ISBN,price, author , title, year);
            case 1:
                String filetype = FILETYPES[random.nextInt(FILETYPES.length)];
                return new EBook(ISBN, title, year, price, author, filetype);
            case 2:
                return new ShowcaseBook(ISBN, title, year, 0.0, author);
            default:
                throw new IllegalStateException("Invalid book type");
        }

    }


    public static void buyRandomBooks(BookStore bookstore, int attempts) {
        List<String> isbns = new ArrayList<>(bookstore.inventory.keySet());
        for (int i = 0; i < attempts && !isbns.isEmpty(); i++) {
            String isbn = isbns.get(random.nextInt(isbns.size()));
            int quantity = 1 + random.nextInt(5);
            try {
                double amount = bookstore.buyBook(isbn, quantity, "test@email.com", "123 Street");
                System.out.println(" book store: Paid " + amount + " for " + quantity + " copies of book with ISBN " + isbn);
            } catch (Exception e) {
                System.out.println("book store: Failed to buy book with ISBN " + isbn + ": " + e.getMessage());
            }
        }
    }
    public static void removeOutdatedBooks(BookStore bookstore, int currentYear, int maxAge) {
        try {
            List<Book> outdated = bookstore.removeOutdatedBooks(currentYear, maxAge);
            System.out.println("book store: Removed " + outdated.size() + " outdated books.");
            for (Book book : outdated) {
                System.out.println("book store: - " + book.getTitle() + " (" + book.getYear() + ")");
            }
        } catch (Exception e) {
            System.out.println(" book store: Error removing outdated books: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BookStore bookstore = new BookStore();

        addRandomBooks(bookstore, 7);


        buyRandomBooks(bookstore, 5);


        removeOutdatedBooks(bookstore, 2025, 10);

    }
}