package objectoriented.constructors.level1;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.address = "Unknown";
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
        this.address = other.address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Creating Original Person ---");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Person original = new Person(name, age, address);

        System.out.println("\n--- Original Person Details ---");
        original.displayDetails();

        Person copy = new Person(original);

        System.out.println("\n--- Copied Person Details (using Copy Constructor) ---");
        copy.displayDetails();

        System.out.println("\n--- Modifying Original Person ---");
        original.setName("Modified Name");
        original.setAge(99);

        System.out.println("\n--- Original After Modification ---");
        original.displayDetails();

        System.out.println("\n--- Copy Remains Unchanged ---");
        copy.displayDetails();

        scanner.close();
    }
}
