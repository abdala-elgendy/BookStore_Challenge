public abstract class Book {

    private String ISBN ;
    private String name ;
    private double price ;
    private String author ;


    public Book(String ISBN, double price, String author) {
        this.ISBN = ISBN;
        this.price = price;
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
