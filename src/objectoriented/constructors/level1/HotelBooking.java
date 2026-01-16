package objectoriented.constructors.level1;

import java.util.Scanner;

public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    private double getRoomRate() {
        switch (roomType.toLowerCase()) {
            case "deluxe":
                return 150.0;
            case "suite":
                return 250.0;
            case "standard":
            default:
                return 80.0;
        }
    }

    public double calculateTotalCost() {
        return getRoomRate() * nights;
    }

    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
        System.out.println("Rate per Night: $" + getRoomRate());
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Default Booking ---");
        HotelBooking defaultBooking = new HotelBooking();
        defaultBooking.displayBookingDetails();

        System.out.println("\n--- Parameterized Booking ---");
        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter Room Type (Standard/Deluxe/Suite): ");
        String roomType = scanner.nextLine();
        System.out.print("Enter Number of Nights: ");
        int nights = scanner.nextInt();

        HotelBooking customBooking = new HotelBooking(guestName, roomType, nights);
        customBooking.displayBookingDetails();

        System.out.println("\n--- Copy Booking (using Copy Constructor) ---");
        HotelBooking copyBooking = new HotelBooking(customBooking);
        copyBooking.displayBookingDetails();

        scanner.close();
    }
}
