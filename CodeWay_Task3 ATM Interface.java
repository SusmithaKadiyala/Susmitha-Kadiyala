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
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Current Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class ATMApp {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter option (1-4): ");
            int option = scanner.nextInt();

            if (option >= 1 && option <= 4) {
                atm.executeOption(option);
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
