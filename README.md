# HexSoftwares Banking System

## Project Overview

This is a comprehensive **Simple Banking System** project built in Java as part of the HexSoftwares Internship Program. The system implements a functional banking application with support for creating accounts, depositing money, withdrawing money, and checking account balances with robust error handling.

## Features

### Core Functionality
- ✅ **Create Bank Accounts** - Create multiple accounts for customers
- ✅ **Deposit Money** - Add funds to accounts with validation
- ✅ **Withdraw Money** - Withdraw funds with balance checking
- ✅ **Check Balance** - View current account balance
- ✅ **Error Handling** - Prevent invalid operations like overdrafts
- ✅ **Customer Management** - Manage customer information and their accounts
- ✅ **Interactive Menu** - User-friendly command-line interface
- ✅ **Demo Transactions** - Sample transactions to showcase functionality

## Project Structure

```
HexSoftwares_Banking_System/
├── src/
│   ├── BankAccount.java       # Bank account class with deposit/withdraw logic
│   ├── Customer.java          # Customer class managing accounts
│   ├── BankingSystem.java     # Main class with interactive menu
│   └── BankingSystemTest.java # Unit tests (optional)
├── README.md                   # Project documentation
├── COMPILATION.md             # Compilation and execution guide
└── .gitignore                 # Git ignore file
```

## Class Description

### BankAccount.java
Represents a single bank account with the following methods:
- `deposit(double amount)` - Add money to account
- `withdraw(double amount)` - Remove money from account
- `getBalance()` - Get current balance
- `displayAccountDetails()` - Display account information

**Error Handling:**
- Prevents negative deposits or withdrawals
- Prevents withdrawals exceeding available balance
- Throws `IllegalArgumentException` for invalid operations

### Customer.java
Represents a customer who can have multiple accounts:
- `createAccount(String accountNumber, double initialBalance)` - Create new account
- `getAccount(String accountNumber)` - Retrieve account by number
- `displayAllAccounts()` - Show all accounts
- `getTotalBalance()` - Calculate total balance across all accounts

**Features:**
- Manages multiple accounts per customer
- Prevents duplicate account numbers
- Validates initial balances

### BankingSystem.java
Main application class with interactive menu:
- Account management operations
- Interactive user interface
- Demo transaction showcase
- Input validation

## How to Use

### Compilation
```bash
# Navigate to src directory
cd src

# Compile all Java files
javac *.java
```

### Execution
```bash
# Run the main program
java BankingSystem
```

### Interactive Menu Options
```
1. View All Accounts      - Display all customer accounts
2. Deposit Money          - Add funds to an account
3. Withdraw Money         - Remove funds from an account
4. Check Balance          - View account balance
5. View Total Balance     - See total balance across all accounts
6. View Account Details   - Display detailed account information
7. Demo Transactions      - Run sample transactions
8. Exit                   - Close the application
```

## Usage Example

```java
// Create a customer
Customer customer = new Customer("CUST001", "John Doe", "john@example.com", "555-1234");

// Create accounts
BankAccount savings = customer.createAccount("SA001", 5000.00);
BankAccount checking = customer.createAccount("CA001", 2000.00);

// Perform operations
savings.deposit(1000);        // Add $1000
savings.withdraw(500);        // Remove $500
double balance = savings.getBalance(); // Get balance

// Try invalid operations (will throw exception)
try {
    savings.withdraw(10000);  // Error: Insufficient funds
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## Error Handling Examples

### Insufficient Balance
```
✗ Error: Insufficient funds! Available balance: $500.00
```

### Invalid Amount
```
✗ Error: Deposit amount must be greater than zero
```

### Duplicate Account
```
✗ Error: Account number already exists!
```

## Demo Transactions

The system includes a demo feature that performs sample transactions:
1. Deposit $1000 to Savings Account
2. Withdraw $500 from Checking Account
3. Transfer $800 from Savings to Checking
4. Display final balances

## Requirements

- **Java Version:** JDK 8 or higher
- **IDE:** Any Java IDE (Eclipse, IntelliJ IDEA, NetBeans) or command-line compiler
- **Operating System:** Windows, macOS, or Linux

## Key Concepts Demonstrated

- **Object-Oriented Programming (OOP)**
  - Encapsulation
  - Abstraction
  - Class design
  - Inheritance (extensible for more account types)

- **Error Handling**
  - Exception throwing
  - Try-catch blocks
  - Input validation

- **Data Structures**
  - ArrayList for managing multiple accounts
  - Proper getter/setter implementation

- **User Interface**
  - Menu-driven application
  - Input validation
  - Formatted output

## Extension Ideas

Potential features to extend this system:
- Transaction history logging
- Interest calculation for savings accounts
- Loan management
- Bill payment functionality
- Account overdraft protection
- Multi-currency support
- Database integration
- GUI implementation using Swing/JavaFX

## Testing

The application has been tested for:
- ✓ Valid deposits and withdrawals
- ✓ Balance calculations
- ✓ Error handling for overdrafts
- ✓ Multiple account management
- ✓ Input validation
- ✓ Exception handling

## Author

**Rahul Singh Kushwah**
- GitHub: [@Ishadowprince716](https://github.com/Ishadowprince716)
- Email: patelmrrahul199@gmail.com
- Institution: RGPV University, Bhopal

## License

This project is created for educational purposes as part of the HexSoftwares Internship Program.

## Contact

For questions or suggestions about this project:
- **Email:** info@hexsoftwares.tech
- **Phone:** +91 9695040540
- **Website:** www.hexsoftwares.tech

## Acknowledgments

- HexSoftwares for providing the internship opportunity
- Thanks to all mentors and instructors for guidance

---

**Last Updated:** November 15, 2025
**Version:** 1.0.0
