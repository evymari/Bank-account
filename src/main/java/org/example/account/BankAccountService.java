package org.example.account;

public class BankAccountService {
    // Create a new Bank Account

    // Create a new Bank Account
    public BankAccount createAccount(float initialBalance, float annualInterestRate) {
        return new BankAccount(initialBalance, annualInterestRate);
    }

    public SavingsAccount createSavingsAccount(float initialBalance, float annualInterestRate) {
        return new SavingsAccount(initialBalance, annualInterestRate);
    }

    public CheckingAccount createCheckingAccount(float initialBalance, float annualInterestRate) {
        return new CheckingAccount(initialBalance, annualInterestRate);
    }

    // Deposit money into account
    public void deposit(BankAccount account, float amount) {
        account.deposit(amount);
    }

    // Withdraw money from account
    public void withdraw(BankAccount account, float amount) {
        account.withdraw(amount);
    }

    // Generate monthly statement
    public void generateMonthlyStatement(BankAccount account) {
        account.generateMonthlyStatement();
    }

    // Get account details
    public String getAccountDetails(BankAccount account) {
        return account.printAccountDetails();
    }
}


