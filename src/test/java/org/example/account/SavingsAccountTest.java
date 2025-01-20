package org.example.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    @Test
    void testConstructor() {
        SavingsAccount account = new SavingsAccount(15000.0f, 5.0f);
        assertTrue(account.isActive(), "La cuenta debería estar activa.");
        assertEquals(15000.0f, account.balance, 0.01);
    }

    @Test
    void testDepositWhenActive() {
        SavingsAccount account = new SavingsAccount(15000.0f, 5.0f);
        account.deposit(5000.0f);
        assertEquals(20000.0f, account.balance, 0.01);
    }

    @Test
    void testDepositWhenInactive() {
        SavingsAccount account = new SavingsAccount(9000.0f, 5.0f);
        account.deposit(2000.0f); // Intento de consignar con cuenta inactiva
        assertEquals(9000.0f, account.balance, 0.01); // No debe cambiar
    }

    @Test
    void testWithdrawWhenActive() {
        SavingsAccount account = new SavingsAccount(15000.0f, 5.0f);
        account.withdraw(5000.0f);
        assertEquals(10000.0f, account.balance, 0.01);
    }

    @Test
    void testWithdrawWhenInactive() {
        SavingsAccount account = new SavingsAccount(9000.0f, 5.0f);
        account.withdraw(1000.0f); // Intento de retirar con cuenta inactiva
        assertEquals(9000.0f, account.balance, 0.01); // No debe cambiar
    }

    @Test
    void testGenerateMonthlyStatement() {
        SavingsAccount account = new SavingsAccount(15000.0f, 6.0f);
        account.monthlyFee = 500.0f;
        account.generateMonthlyStatement();
        assertEquals(14575.0f, account.balance, 0.01);
    }

    @Test
    void testPrintAccountDetails() {
        SavingsAccount account = new SavingsAccount(15000.0f, 5.0f);
        String details = account.printAccountDetails();
        String expectedDetails = "Balance: 15000.0, Annual Interest Rate: 5.0, Monthly Fee: 0.0, Deposits: 0, Withdrawals: 0";
        assertTrue(details.contains("Balance: 15000.0"));
        assertTrue(details.contains("Active: true"));
    }

    @Test
    void testAccountBecomesInactive() {
        SavingsAccount account = new SavingsAccount(12000.0f, 5.0f);
        account.withdraw(3000.0f);
        assertTrue(account.isActive(), "La cuenta debería volverse inactiva.");
    }
}

