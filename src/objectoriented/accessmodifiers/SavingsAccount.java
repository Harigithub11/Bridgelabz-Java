package objectoriented.accessmodifiers;

import java.util.Scanner;

public class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MINIMUM_BALANCE = 500.0;

    public SavingsAccount() {
        super();
        this.interestRate = 3.5;
    }

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * (interestRate / 100);
    }

    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
        System.out.println("Interest of $" + interest + " applied.");
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < MINIMUM_BALANCE) {
            System.out.println("Cannot withdraw. Minimum balance of $" + MINIMUM_BALANCE + " must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Account Number (public): " + accountNumber);
        System.out.println("Account Holder (protected - accessible in subclass): " + accountHolder);
        System.out.println("Balance (private - accessed via getter): $" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance Required: $" + MINIMUM_BALANCE);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Savings Account Creation ---");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter Interest Rate (%): ");
        double interestRate = scanner.nextDouble();

        SavingsAccount savings = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);

        int choice;
        do {
            System.out.println("\n--- Savings Account Menu ---");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    savings.displayDetails();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    savings.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    savings.withdraw(withdrawAmount);
                    break;
                case 4:
                    savings.applyInterest();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
