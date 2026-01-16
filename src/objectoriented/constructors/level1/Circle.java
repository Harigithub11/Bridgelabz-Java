package objectoriented.constructors.level1;

import java.util.Scanner;

public class Circle {
    private static final double PI = 3.14159;
    private static final double DEFAULT_RADIUS = 1.0;
    private double radius;

    public Circle() {
        this(DEFAULT_RADIUS);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.printf("Area: %.2f\n", calculateArea());
        System.out.printf("Circumference: %.2f\n", calculateCircumference());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Circle with Default Constructor (Constructor Chaining) ---");
        Circle defaultCircle = new Circle();
        defaultCircle.displayDetails();

        System.out.println("\n--- Circle with Parameterized Constructor ---");
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        Circle customCircle = new Circle(radius);
        customCircle.displayDetails();

        scanner.close();
    }
}
