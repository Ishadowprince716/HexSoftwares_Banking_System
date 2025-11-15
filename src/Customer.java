/**
 * Customer.java
 * Represents a customer with an associated bank account
 */

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<BankAccount> accounts;
    
    /**
     * Constructor to initialize a customer
     * @param customerId Unique customer ID
     * @param name Customer's name
     * @param email Customer's email
     * @param phoneNumber Customer's phone number
     */
    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }
    
    /**
     * Create a new account for this customer
     * @param accountNumber Unique account number
     * @param initialBalance Initial balance
     * @return The created BankAccount
     * @throws IllegalArgumentException if account number already exists
     */
    public BankAccount createAccount(String accountNumber, double initialBalance) {
        // Check if account already exists
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                throw new IllegalArgumentException("Account number already exists!");
            }
        }
        
        BankAccount newAccount = new BankAccount(accountNumber, this.name, initialBalance);
        accounts.add(newAccount);
        System.out.println("✓ Account created successfully for " + this.name);
        return newAccount;
    }
    
    /**
     * Get an account by account number
     * @param accountNumber The account number to search for
     * @return The BankAccount if found, null otherwise
     */
    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    
    /**
     * Display all accounts for this customer
     */
    public void displayAllAccounts() {
        System.out.println("\n=== Accounts for " + this.name + " ===");
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (int i = 0; i < accounts.size(); i++) {
                BankAccount account = accounts.get(i);
                System.out.println((i + 1) + ". Account Number: " + account.getAccountNumber() + 
                                 ", Balance: $" + String.format("%.2f", account.getBalance()));
            }
        }
        System.out.println("========================");
    }
    
    /**
     * Display customer details
     */
    public void displayCustomerDetails() {
        System.out.println("\n--- Customer Information ---");
        System.out.println("Customer ID: " + this.customerId);
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Number of Accounts: " + accounts.size());
        System.out.println("----------------------------");
    }
    
    /**
     * Calculate total balance across all accounts
     * @return Total balance
     */
    public double getTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
    
    // Getters
    public String getCustomerId() {
        return customerId;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }
}
