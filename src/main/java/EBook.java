class EBook extends Book {
    private final String filetype;

    public EBook(String ISBN, String title, String year, double price, String author, String filetype) {
        super(ISBN, price, author,title, year);
        this.filetype = filetype;
    }

    public String getFiletype() { return filetype; }



    @Override
    public double buy(int quantity, String address, String email) {
        double total = getPrice() * quantity;
        MailService.sendEBook(this, email, quantity);
        return total;
    }
}