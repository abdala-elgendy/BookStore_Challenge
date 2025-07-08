public class PaperBook extends Book {


    private int quantity;
    public PaperBook(int quantity,String ISBN, double price, String author, String title, String year) {
        super(ISBN, price, author, title, year);
        this.quantity = quantity;

    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }
    @Override
    public double buy(int quantityWanted, String address, String email) {
        if (quantityWanted > this.quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        if (quantityWanted <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        this.quantity -= quantityWanted;
        System.out.println("Book purchased successfully. Address: " + address + ", Email: " + email);
        return getPrice() * quantityWanted;
    }
}
