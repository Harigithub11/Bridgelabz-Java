package objectoriented.accessmodifiers;

public class Book {
    public String isbn;
    protected String title;
    private String author;

    public Book() {
        this.isbn = "000-0-00-000000-0";
        this.title = "Unknown";
        this.author = "Unknown";
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
