/**
 * BankingSystem.java
 * Main class demonstrating the banking system functionality
 */

import java.util.Scanner;

public class BankingSystem {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   Welcome to Simple Banking System      ║");
        System.out.println("║   HexSoftwares Internship Project       ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        // Create a customer
        Customer customer = new Customer("CUST001", "John Doe", "john@example.com", "555-1234");
        
        // Display customer information
        customer.displayCustomerDetails();
        
        // Create accounts for the customer
        try {
            BankAccount savingsAccount = customer.createAccount("SA001", 5000.00);
            BankAccount checkingAccount = customer.createAccount("CA001", 2000.00);
            
            // Display menu-driven interface
            displayMenu(customer, savingsAccount, checkingAccount);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    /**
     * Display interactive menu for banking operations
     */
    private static void displayMenu(Customer customer, BankAccount savingsAccount, 
                                   BankAccount checkingAccount) {
        boolean running = true;
        
        while (running) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║           Banking Menu                  ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. View All Accounts                   ║");
            System.out.println("║ 2. Deposit Money                       ║");
            System.out.println("║ 3. Withdraw Money                      ║");
            System.out.println("║ 4. Check Balance                       ║");
            System.out.println("║ 5. View Total Balance                  ║");
            System.out.println("║ 6. View Account Details                ║");
            System.out.println("║ 7. Demo: Perform Sample Transactions   ║");
            System.out.println("║ 8. Exit                                ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        customer.displayAllAccounts();
                        break;
                    case 2:
                        performDeposit(savingsAccount, checkingAccount);
                        break;
                    case 3:
                        performWithdraw(savingsAccount, checkingAccount);
                        break;
                    case 4:
                        checkBalance(savingsAccount, checkingAccount);
                        break;
                    case 5:
                        System.out.println("\nTotal Balance across all accounts: $" + 
                                         String.format("%.2f", customer.getTotalBalance()));
                        break;
                    case 6:
                        savingsAccount.displayAccountDetails();
                        checkingAccount.displayAccountDetails();
                        break;
                    case 7:
                        performDemoTransactions(savingsAccount, checkingAccount);
                        break;
                    case 8:
                        running = false;
                        System.out.println("\nThank you for using our banking system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n✗ Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n✗ Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    /**
     * Perform deposit operation
     */
    private static void performDeposit(BankAccount savingsAccount, BankAccount checkingAccount) {
        System.out.println("\n--- Deposit Money ---");
        System.out.println("1. Savings Account (SA001)");
        System.out.println("2. Checking Account (CA001)");
        System.out.print("Select account (1/2): ");
        
        int accountChoice = scanner.nextInt();
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        
        try {
            if (accountChoice == 1) {
                savingsAccount.deposit(amount);
            } else if (accountChoice == 2) {
                checkingAccount.deposit(amount);
            } else {
                System.out.println("Invalid account selection.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Perform withdrawal operation
     */
    private static void performWithdraw(BankAccount savingsAccount, BankAccount checkingAccount) {
        System.out.println("\n--- Withdraw Money ---");
        System.out.println("1. Savings Account (SA001)");
        System.out.println("2. Checking Account (CA001)");
        System.out.print("Select account (1/2): ");
        
        int accountChoice = scanner.nextInt();
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        
        try {
            if (accountChoice == 1) {
                savingsAccount.withdraw(amount);
            } else if (accountChoice == 2) {
                checkingAccount.withdraw(amount);
            } else {
                System.out.println("Invalid account selection.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    
    /**
     * Check balance for both accounts
     */
    private static void checkBalance(BankAccount savingsAccount, BankAccount checkingAccount) {
        System.out.println("\n--- Account Balances ---");
        System.out.println("Savings Account (SA001): $" + 
                         String.format("%.2f", savingsAccount.getBalance()));
        System.out.println("Checking Account (CA001): $" + 
                         String.format("%.2f", checkingAccount.getBalance()));
        System.out.println("------------------------");
    }
    
    /**
     * Perform demo transactions to showcase the system
     */
    private static void performDemoTransactions(BankAccount savingsAccount, 
                                               BankAccount checkingAccount) {
        System.out.println("\n=== Demo: Sample Transactions ===");
        
        try {
            System.out.println("\n1. Deposit $1000 to Savings Account");
            savingsAccount.deposit(1000);
            
            System.out.println("\n2. Withdraw $500 from Checking Account");
            checkingAccount.withdraw(500);
            
            System.out.println("\n3. Transfer $800 from Savings to Checking");
            savingsAccount.withdraw(800);
            checkingAccount.deposit(800);
            
            System.out.println("\n4. Display Final Balances");
            checkBalance(savingsAccount, checkingAccount);
            
            System.out.println("\n✓ Demo transactions completed successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Error during demo: " + e.getMessage());
        }
    }
}
