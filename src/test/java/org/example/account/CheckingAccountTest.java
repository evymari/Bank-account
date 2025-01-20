package org.example.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CheckingAccountTest {

    @Test
    void testInitialBalance() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        assertEquals(5000, account.balance);
    }

    @Test
    void testDeposit() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        account.deposit(3000);
        assertEquals(8000, account.balance);
    }

    @Test
    void testWithdrawWithinBalance() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        account.withdraw(2000);
        assertEquals(3000, account.balance);
    }

    @Test
    void testWithdrawExceedingBalance() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        account.withdraw(7000);
        assertEquals(0, account.balance);
        assertEquals(2000, account.getOverdraft());
    }

    @Test
    void testDepositCoversOverdraft() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        account.withdraw(7000);
        account.deposit(3000);
        assertEquals(1000, account.balance);
        assertEquals(0, account.getOverdraft());
    }

    @Test
    void testPrintAccountDetails() {
        CheckingAccount account = new CheckingAccount(5000, 12);
        account.deposit(3000);
        account.withdraw(2000);
        String details = account.printAccountDetails();
        assertTrue(details.contains("Balance: 6000"));
        assertTrue(details.contains("Overdraft: 0"));
        assertTrue(details.contains("Total Transactions: 2"));
    }
}