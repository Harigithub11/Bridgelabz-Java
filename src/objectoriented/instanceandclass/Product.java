package objectoriented.instanceandclass;

import java.util.Scanner;

public class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public Product() {
        this.productName = "Unknown";
        this.price = 0.0;
        totalProducts++;
    }

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products to create: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1) + ":");
            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            products[i] = new Product(name, price);
        }

        System.out.println("\n--- All Products ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1) + ":");
            products[i].displayProductDetails();
        }

        System.out.println();
        Product.displayTotalProducts();

        scanner.close();
    }
}
