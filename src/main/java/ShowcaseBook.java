class ShowcaseBook extends Book {
    public ShowcaseBook(String ISBN, String title, String year, double price, String author) {
        super(ISBN, price, author ,title, year);
    }

    @Override
    public double buy(int quantity, String email, String address)  {
        System.out.println("Showcase books are not for sale: " + getTitle());
        return 0.0;
    }
}
