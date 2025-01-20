package org.example.account;

public class CheckingAccount extends BankAccount{


    private float overdraft;

    public CheckingAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);
        this.overdraft = 0;
    }

    @Override
    public void withdraw(float amount) {
        if (amount > balance) {
            overdraft += (amount - balance);
            balance = 0;
        } else {
            balance -= amount;
        }
        numWithdrawals++;
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) {
            if (amount >= overdraft) {
                amount -= overdraft;
                overdraft = 0;
            } else {
                overdraft -= amount;
                amount = 0;
            }
        }
        super.deposit(amount);
    }

    @Override
    public String printAccountDetails() {
        return super.printAccountDetails() + ", Overdraft: " + overdraft + ", Total Transactions: " + (numDeposits + numWithdrawals);
    }

    // Agregar el método getter para overdraft
    public float getOverdraft() {
        return overdraft;
    }
}