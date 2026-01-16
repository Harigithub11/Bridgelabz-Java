package objectoriented.constructors.level1;

import java.util.Scanner;

public class CarRental {
    private static final double ECONOMY_RATE = 30.0;
    private static final double SEDAN_RATE = 50.0;
    private static final double SUV_RATE = 80.0;
    private static final double LUXURY_RATE = 150.0;

    private String customerName;
    private String carModel;
    private String carType;
    private int rentalDays;

    public CarRental() {
        this.customerName = "Guest";
        this.carModel = "Standard Car";
        this.carType = "Economy";
        this.rentalDays = 1;
    }

    public CarRental(String customerName, String carModel, String carType, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.carType = carType;
        this.rentalDays = rentalDays;
    }

    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel = other.carModel;
        this.carType = other.carType;
        this.rentalDays = other.rentalDays;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    private double getDailyRate() {
        switch (carType.toLowerCase()) {
            case "sedan":
                return SEDAN_RATE;
            case "suv":
                return SUV_RATE;
            case "luxury":
                return LUXURY_RATE;
            case "economy":
            default:
                return ECONOMY_RATE;
        }
    }

    public double calculateTotalCost() {
        double baseCost = getDailyRate() * rentalDays;
        double discount = 0;
        if (rentalDays >= 7) {
            discount = baseCost * 0.10;
        } else if (rentalDays >= 3) {
            discount = baseCost * 0.05;
        }
        return baseCost - discount;
    }

    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Car Type: " + carType);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: $" + getDailyRate());
        System.out.printf("Total Cost: $%.2f\n", calculateTotalCost());
        if (rentalDays >= 7) {
            System.out.println("(10% discount applied for 7+ days)");
        } else if (rentalDays >= 3) {
            System.out.println("(5% discount applied for 3+ days)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Car Rental System ---");
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter Car Type (Economy/Sedan/SUV/Luxury): ");
        String carType = scanner.nextLine();
        System.out.print("Enter Number of Rental Days: ");
        int rentalDays = scanner.nextInt();

        CarRental rental = new CarRental(customerName, carModel, carType, rentalDays);

        System.out.println("\n--- Rental Details ---");
        rental.displayRentalDetails();

        scanner.close();
    }
}
