package objectoriented.accessmodifiers;

import java.util.Scanner;

public class EBook extends Book {
    private double fileSize;
    private String format;

    public EBook() {
        super();
        this.fileSize = 0.0;
        this.format = "PDF";
    }

    public EBook(String isbn, String title, String author, double fileSize, String format) {
        super(isbn, title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public void displayDetails() {
        System.out.println("ISBN (public): " + isbn);
        System.out.println("Title (protected - accessible in subclass): " + title);
        System.out.println("Author (private - accessed via getter): " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Format: " + format);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- EBook Registration ---");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter File Size (MB): ");
        double fileSize = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Format (PDF/EPUB/MOBI): ");
        String format = scanner.nextLine();

        EBook ebook = new EBook(isbn, title, author, fileSize, format);

        System.out.println("\n--- EBook Details ---");
        ebook.displayDetails();

        System.out.print("\nUpdate Author? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new Author: ");
            String newAuthor = scanner.nextLine();
            ebook.setAuthor(newAuthor);
            System.out.println("Updated Author: " + ebook.getAuthor());
        }

        scanner.close();
    }
}
