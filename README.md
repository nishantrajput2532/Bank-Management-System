🏦 Java Console Banking System:
A robust, menu-driven banking simulation built in Java. This project demonstrates core Object-Oriented Programming (OOP) principles by simulating a real-world banking environment where users can create accounts, manage funds, and utilize specific account features like overdrafts and interest accumulation.

📖 Overview
The Java Console Banking System is designed to handle multiple types of bank accounts with distinct rules. It provides an interactive command-line interface (CLI) for users to perform financial operations safely.

The system differentiates between:

Savings Account: Focuses on saving; allows interest accumulation but strictly forbids overdrafts.
Current Account: Focuses on fluidity; allows withdrawals exceeding the balance up to a set overdraft limit.


✨ Key Features
Account Management: Create new Savings or Current accounts with custom holder names and initial balances.

Secure Deposits: Validates inputs to ensure only positive amounts are deposited.

    Polymorphic Withdrawals:

      Savings: Checks against current balance.

      Current: Checks against balance + overdraft limit ($500).

Interest Calculation: Calculates and adds 5% interest (exclusive to Savings Accounts).

Interactive Menu: A loop-based menu allowing users to perform multiple operations without restarting the program.


🛠️ OOP Concepts Applied:
  This project serves as a practical implementation of the four pillars of OOP: 
  
    Abstraction:	The Account class is abstract, providing a blueprint (e.g., abstract void withdraw()) without defining the specific logic.

    Inheritance:	SavingsAccount and CurrentAccount extend the base Account class to inherit common fields like accountNumber and balance.

    Polymorphism:	 The withdraw() method is overridden in both child classes to handle funds differently (Strict limit vs. Overdraft).

    Encapsulation:	Fields like balance and accountHolderName are protected/private and accessed via methods to maintain data integrity.

🔮 Future Improvements:

  [ ] Add File Handling to save account data permanently (persistence).

  [ ] Implement a Transaction History (ArrayList of logs).

  [ ] specific Exception Handling (Custom InsufficientFundsException).

  [ ] Add a PIN authentication system.

