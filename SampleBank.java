package PracticeProject;
import java.util.*;

import static java.lang.System.in;

//Base Class
abstract class Account{
    private String accountNumber;
    private String accountHolderName;
    protected double balance;

    public Account(String accountNumber, String accountHolderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("⚠️ Deposit amount must be positive!");
            return;
        }

        balance = balance + amount;
        System.out.printf("✅ Deposited: $%.2f%n", amount);
    }

    public abstract void withdraw(double amount);  //abstract method

    public void displayBalance()
    {
        System.out.printf("💰 Current Balance: $%.2f%n", balance);
    }

    //Getters
    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }
}

// Derived Class: SavingsAccount
class SavingsAccount extends Account{
    private static final double INTEREST_RATE = 0.05;   // 5%

    public SavingsAccount(String accountNumber, String accountHolderName, double balance)
    {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount)
    {
        if (amount <= 0) {
            System.out.println("⚠️ Withdrawal amount must be positive!");
        }
        else if (amount <= balance){
            balance = balance - amount;
            System.out.printf("💸 Withdrawn: $%.2f%n", amount);
        }
        else {
            System.out.println("⚠️ Insufficient balance!");
        }

    }

    public void addInterest(){

        double interest = balance * INTEREST_RATE;
        balance = balance + interest;
        System.out.printf("🎁 Interest added: $%.2f%n", interest);

    }
}

//Derived Class: CurrentAccount
class CurrentAccount extends Account{
    private static final double OVERDRAFT_LIMIT = 500.0;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance)
    {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw(double amount)
    {
        if (amount <= 0) {
            System.out.println("⚠️ Withdrawal amount must be positive!");
        } else if (amount <= balance + OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.printf("💸 Withdrawn: $%.2f%n", amount);
        } else {
            System.out.println("⚠️ Withdrawal exceeds overdraft limit!");
        }

    }
}

// Main Application
public class SampleBank {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Account account = null;

        System.out.println("🏦 Welcome to Java Bank System");
        System.out.println("1. Open Savings Account");
        System.out.println("2. Open Current Account");
        System.out.print("Choose account type: ");

        int choice = sc.nextInt();

        sc.nextLine(); // consume newline

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (choice == 1)
        {
            account = new SavingsAccount(accNo, name, balance);
        }
        else if (choice == 2)
        {
            account = new CurrentAccount(accNo, name, balance);
        }
        else
        {
            System.out.println("❌ Invalid choice. Exiting...");
            sc.close();
            return;
        }

        runBankMenu(sc, account);
        sc.close();

    }

    // 🔹 Menu Logic in Separate Method
    private static void runBankMenu(Scanner sc, Account account)
    {
        int option;
        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavingsAccount)
                System.out.println("4. Add Interest");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            option = sc.nextInt();

            switch (option){
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    account.displayBalance();
                    break;

                case 4:
                    if (account instanceof SavingsAccount) {
                        ((SavingsAccount) account).addInterest();
                    } else {
                        System.out.println("⚠️ Interest not applicable for Current Accounts.");
                    }
                    break;

                case 0:
                    System.out.println("👋 Thank you for banking with us!");
                    break;
                default:
                    System.out.println("❌ Invalid option.");
            }
        }while (option != 0);
    }
}
