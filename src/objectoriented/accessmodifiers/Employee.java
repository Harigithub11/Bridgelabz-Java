package objectoriented.accessmodifiers;

public class Employee {
    public int employeeId;
    protected String department;
    private double salary;

    public Employee() {
        this.employeeId = 0;
        this.department = "Unknown";
        this.salary = 0.0;
    }

    public Employee(int employeeId, String department, double salary) {
        this.employeeId = employeeId;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
            System.out.println("Salary updated to: $" + salary);
        } else {
            System.out.println("Invalid salary. Cannot be negative.");
        }
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}
