package objectoriented.accessmodifiers;

import java.util.Scanner;

public class PostgraduateStudent extends Student {
    private String researchTopic;
    private String supervisor;

    public PostgraduateStudent() {
        super();
        this.researchTopic = "Not Assigned";
        this.supervisor = "Not Assigned";
    }

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String researchTopic, String supervisor) {
        super(rollNumber, name, cgpa);
        this.researchTopic = researchTopic;
        this.supervisor = supervisor;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        this.researchTopic = researchTopic;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public void displayDetails() {
        System.out.println("Roll Number (public): " + rollNumber);
        System.out.println("Name (protected - accessible in subclass): " + name);
        System.out.println("CGPA (private - accessed via getter): " + getCgpa());
        System.out.println("Research Topic: " + researchTopic);
        System.out.println("Supervisor: " + supervisor);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Postgraduate Student Registration ---");
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Research Topic: ");
        String researchTopic = scanner.nextLine();
        System.out.print("Enter Supervisor Name: ");
        String supervisor = scanner.nextLine();

        PostgraduateStudent pgStudent = new PostgraduateStudent(rollNumber, name, cgpa, researchTopic, supervisor);

        System.out.println("\n--- Student Details ---");
        pgStudent.displayDetails();

        System.out.print("\nUpdate CGPA? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new CGPA: ");
            double newCgpa = scanner.nextDouble();
            pgStudent.setCgpa(newCgpa);
            System.out.println("Updated CGPA: " + pgStudent.getCgpa());
        }

        scanner.close();
    }
}
