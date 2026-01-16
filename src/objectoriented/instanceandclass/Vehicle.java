package objectoriented.instanceandclass;

import java.util.Scanner;

public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 500.0;

    public Vehicle() {
        this.ownerName = "Unknown";
        this.vehicleType = "Unknown";
    }

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public static double getRegistrationFee() {
        return registrationFee;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Registration Fee: $" + Vehicle.getRegistrationFee());

        System.out.print("\nEnter number of vehicles to register: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1) + ":");
            System.out.print("Enter Owner Name: ");
            String owner = scanner.nextLine();
            System.out.print("Enter Vehicle Type (Car/Bike/Truck): ");
            String type = scanner.nextLine();

            vehicles[i] = new Vehicle(owner, type);
        }

        System.out.println("\n--- All Registered Vehicles ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1) + ":");
            vehicles[i].displayVehicleDetails();
        }

        System.out.print("\nUpdate Registration Fee? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new Registration Fee: ");
            double newFee = scanner.nextDouble();
            Vehicle.updateRegistrationFee(newFee);

            System.out.println("\n--- All Vehicles After Fee Update ---");
            for (int i = 0; i < n; i++) {
                System.out.println("\nVehicle " + (i + 1) + ":");
                vehicles[i].displayVehicleDetails();
            }
        }

        scanner.close();
    }
}
