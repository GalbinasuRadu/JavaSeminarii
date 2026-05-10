public class Book {

    private String title;
    private String author;
    private boolean borrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }

    public void displayBook() {
        System.out.println(title + " - " + author);
    }
}