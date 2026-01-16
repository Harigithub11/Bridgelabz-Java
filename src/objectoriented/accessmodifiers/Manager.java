package objectoriented.accessmodifiers;

import java.util.Scanner;

public class Manager extends Employee {
    private int teamSize;
    private double bonus;

    public Manager() {
        super();
        this.teamSize = 0;
        this.bonus = 0.0;
    }

    public Manager(int employeeId, String department, double salary, int teamSize, double bonus) {
        super(employeeId, department, salary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double calculateTotalCompensation() {
        return getSalary() + bonus;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee ID (public): " + employeeId);
        System.out.println("Department (protected - accessible in subclass): " + department);
        System.out.println("Salary (private - accessed via getter): $" + getSalary());
        System.out.println("Team Size: " + teamSize);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + calculateTotalCompensation());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Manager Registration ---");
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Team Size: ");
        int teamSize = scanner.nextInt();
        System.out.print("Enter Bonus: ");
        double bonus = scanner.nextDouble();

        Manager manager = new Manager(employeeId, department, salary, teamSize, bonus);

        System.out.println("\n--- Manager Details ---");
        manager.displayDetails();

        System.out.print("\nUpdate Salary? (1-Yes, 0-No): ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.print("Enter new Salary: ");
            double newSalary = scanner.nextDouble();
            manager.setSalary(newSalary);
            System.out.println("\n--- Updated Manager Details ---");
            manager.displayDetails();
        }

        scanner.close();
    }
}
