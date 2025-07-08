public abstract class Book {

    private String ISBN ;
    private String title ;
    private double price ;
    private String author ;
    private String year ;


    public Book(String ISBN, double price, String author, String title, String year) {
        this.ISBN = ISBN;
        this.price = price;
        this.author = author;
        this.title = title;
        this.year = year;

    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public abstract double buy( int quantity, String address , String email);

}
