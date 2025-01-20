package org.example.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testConstructor() {
        BankAccount account = new BankAccount(10000.0f, 5.0f);
        assertEquals(10000.0f, account.balance, 0.01);
        assertEquals(5.0f, account.annualInterestRate, 0.01);
        assertEquals(0, account.numDeposits);
        assertEquals(0, account.numWithdrawals);
        assertEquals(0.0f, account.monthlyFee, 0.01);
    }

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(10000.0f, 5.0f);
        account.deposit(5000.0f);
        assertEquals(15000.0f, account.balance, 0.01);
        assertEquals(1, account.numDeposits);
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(10000.0f, 5.0f);
        account.withdraw(3000.0f);
        assertEquals(7000.0f, account.balance, 0.01);
        assertEquals(1, account.numWithdrawals);
    }

    @Test
    void testWithdrawExceedsBalance() {
        BankAccount account = new BankAccount(5000.0f, 5.0f);
        account.withdraw(6000.0f);
        assertEquals(5000.0f, account.balance, 0.01);
    }

    @Test
    void testGenerateMonthlyStatement() {
        BankAccount account = new BankAccount(15000.0f, 6.0f);
        account.monthlyFee = 500.0f;
        account.generateMonthlyStatement();
        assertEquals(14575.0f, account.balance, 0.01);
    }

    @Test
    void testPrintAccountDetails() {
        BankAccount account = new BankAccount(10000.0f, 5.0f);
        String details = account.printAccountDetails();
        String expectedDetails = "Balance: 10000.0, Annual Interest Rate: 5.0, Monthly Fee: 0.0, Deposits: 0, Withdrawals: 0";
        assertEquals(expectedDetails, details);
    }
}