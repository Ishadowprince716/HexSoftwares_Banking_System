/**
 * BankAccount.java
 * Represents a bank account with deposit, withdrawal, and balance checking functionality
 */

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String accountHolder;
    
    /**
     * Constructor to initialize a bank account
     * @param accountNumber Unique account number
     * @param accountHolder Name of the account holder
     * @param initialBalance Initial balance in the account
     * @throws IllegalArgumentException if initial balance is negative
     */
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    /**
     * Deposit money into the account
     * @param amount Amount to deposit
     * @throws IllegalArgumentException if amount is negative or zero
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        this.balance += amount;
        System.out.println("✓ Deposit successful! Amount: $" + amount);
        System.out.println("  New Balance: $" + String.format("%.2f", this.balance));
    }
    
    /**
     * Withdraw money from the account
     * @param amount Amount to withdraw
     * @throws IllegalArgumentException if amount is invalid or exceeds balance
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds! Available balance: $" + 
                                             String.format("%.2f", this.balance));
        }
        this.balance -= amount;
        System.out.println("✓ Withdrawal successful! Amount: $" + amount);
        System.out.println("  Remaining Balance: $" + String.format("%.2f", this.balance));
    }
    
    /**
     * Get the current balance
     * @return Current account balance
     */
    public double getBalance() {
        return this.balance;
    }
    
    /**
     * Display account details
     */
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Balance: $" + String.format("%.2f", this.balance));
        System.out.println("------------------------");
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
}
