class EBook extends Book {
    private final String filetype;

    public EBook(String ISBN, String title, int year, double price, String author, String filetype) {
        super(ISBN, price, author,title, year);
        this.filetype = filetype;
    }

    public String getFiletype() { return filetype; }



    @Override
    public double buy(int quantity, String address, String email) {
        if (quantity <= 0) {
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

        double total = getPrice() * quantity;
        MailService.sendEBook(this, email, quantity);
        return total;
    }
}