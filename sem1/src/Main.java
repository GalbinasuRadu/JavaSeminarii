public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("Radu", 1000);

        account.deposit(500);

        account.withdraw(300);

        account.displayInfo();

        Library library = new Library();

        Book b1 = new Book("Clean Code", "Robert Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");

        library.addBook(b1);
        library.addBook(b2);

        library.displayBooks();
    }
}