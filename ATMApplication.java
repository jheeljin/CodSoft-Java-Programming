import java.util.Scanner;

// Represents a user's bank account
class Account {
    private double balance;

    // Initialize account with starting balance
    public Account(double startingBalance) {
        this.balance = startingBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit funds into the account
    public void addFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw funds if sufficient balance is available
    public boolean deductFunds(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew ₹" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }
}

// Represents the ATM operations
class ATMInterface {
    private Account account;

    public ATMInterface(Account account) {
        this.account = account;
    }

    public void showMenu() {
        System.out.println("\n=== ATM Options ===");
        System.out.println("1. Withdraw Funds");
        System.out.println("2. Deposit Funds");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }

    public void handleOption(int option, Scanner input) {
        switch (option) {
            case 1:
                System.out.print("Enter the amount to withdraw: ₹");
                if (input.hasNextDouble()) {
                    double withdrawalAmount = input.nextDouble();
                    if (account.deductFunds(withdrawalAmount)) {
                        System.out.println("New balance: ₹" + account.getBalance());
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    input.next(); // consume the invalid input
                }
                break;

            case 2:
                System.out.print("Enter the amount to deposit: ₹");
                if (input.hasNextDouble()) {
                    double depositAmount = input.nextDouble();
                    account.addFunds(depositAmount);
                    System.out.println("New balance: ₹" + account.getBalance());
                } else {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    input.next(); // consume the invalid input
                }
                break;

            case 3:
                System.out.println("Your current balance is: ₹" + account.getBalance());
                break;

            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                break;

            default:
                System.out.println("Invalid option. Please choose between 1 and 4.");
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice == 4) {
                    handleOption(choice, scanner);
                    break;
                }

                handleOption(choice, scanner);
            } else {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.next(); // consume the invalid input
            }
        }

        scanner.close(); // Close the scanner when finished
    }
}

// Main class to run the ATM application
public class ATMApplication {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        Account myAccount = new Account(5000.00); // ₹5,000 initial balance

        // Start the ATM interface
        ATMInterface atm = new ATMInterface(myAccount);
        atm.start();
    }
}
