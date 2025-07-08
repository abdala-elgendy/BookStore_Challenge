class MailService {
    public static void sendEBook(Book book, String email, int quantity) {

        if (book == null || email == null || email.isEmpty() || quantity <= 0) {
            throw new IllegalArgumentException("Invalid parameters for sending eBook");
        }
        System.out.println("Sending " + quantity + " copies of eBook '" + book.getTitle() + "' to " + email);
    }
}
