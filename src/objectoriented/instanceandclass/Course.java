package objectoriented.instanceandclass;

import java.util.Scanner;

public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";

    public Course() {
        this.courseName = "Unknown";
        this.duration = 0;
        this.fee = 0.0;
    }

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public static String getInstituteName() {
        return instituteName;
    }

    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Institute Name: ");
        String institute = scanner.nextLine();
        Course.updateInstituteName(institute);

        System.out.print("\nEnter number of courses to create: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Course[] courses = new Course[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            System.out.print("Enter Course Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Duration (months): ");
            int duration = scanner.nextInt();
            System.out.print("Enter Fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();

            courses[i] = new Course(name, duration, fee);
        }

        System.out.println("\n--- All Courses ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nCourse " + (i + 1) + ":");
            courses[i].displayCourseDetails();
        }

        System.out.print("\nUpdate Institute Name? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new Institute Name: ");
            String newName = scanner.nextLine();
            Course.updateInstituteName(newName);

            System.out.println("\n--- All Courses After Update ---");
            for (int i = 0; i < n; i++) {
                System.out.println("\nCourse " + (i + 1) + ":");
                courses[i].displayCourseDetails();
            }
        }

        scanner.close();
    }
}
