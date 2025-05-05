import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
            return false;
        }
    }
}
public class ATMInterface {
    private BankAccount account;

    public ATMInterface(BankAccount account) {
        this.account = account;
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your current balance is: $" + account.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        if (sc.hasNextDouble()) {
                            double depositAmount = sc.nextDouble();
                            account.deposit(depositAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            sc.next();
                        }
                        break;
                    case 3:
                        System.out.print("Enter the amount to withdraw: ");
                        if (sc.hasNextDouble()) {
                            double withdrawAmount = sc.nextDouble();
                            account.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Invalid input. Please enter a valid amount.");
                            sc.next();
                        }
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                sc.next();
            }
        } while (choice != 4);

        sc.close();
    }
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0);
        ATMInterface atm = new ATMInterface(userAccount);
        atm.start();
    }
}