package org.example.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountServiceTest {


    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(5000, 5);
        account.deposit(1000);
        assertEquals(6000, account.balance, 0.01, "El balance después del depósito no es correcto.");
    }

    @Test
    void testDepositInvalidAmount() {
        BankAccount account = new BankAccount(5000, 5);
        account.deposit(-100);
        assertEquals(5000, account.balance, 0.01, "No se debe permitir depósitos negativos.");
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(5000, 5);
        account.withdraw(2000);
        assertEquals(3000, account.balance, 0.01, "El balance después del retiro no es correcto.");
    }

    @Test
    void testWithdrawExceedsBalance() {
        BankAccount account = new BankAccount(5000, 5);
        account.withdraw(6000);
        assertEquals(5000, account.balance, 0.01, "No se debe permitir retirar más de lo disponible.");
    }

    @Test
    void testWithdrawNegativeAmount() {
        BankAccount account = new BankAccount(5000, 5);
        account.withdraw(-500);
        assertEquals(5000, account.balance, 0.01, "No se debe permitir retirar cantidades negativas.");
    }

    @Test
    void testGenerateMonthlyStatement() {
        BankAccount account = new BankAccount(15000, 6); // 6% anual
        account.monthlyFee = 500; // Comisión mensual
        account.generateMonthlyStatement();

        // Nuevo saldo esperado si la lógica cambia
        // Saldo inicial = 15000
        // Intereses = 15000 * 0.005 = 75
        // Nuevo saldo = 15000 + 75 - 500 = 14575
        assertEquals(14575, account.balance, 0.01, "El balance después del estado mensual no es correcto.");
    }

    @Test
    void testGenerateMonthlyStatementWithNoFee() {
        BankAccount account = new BankAccount(10000, 12); // 12% anual
        account.generateMonthlyStatement();
        assertEquals(10100, account.balance, 0.01, "El balance después del estado mensual con 1% de interés no es correcto.");
    }

    @Test
    void testPrintAccountDetails() {
        BankAccount account = new BankAccount(12000, 5);
        account.deposit(2000);
        account.withdraw(1000);
        String details = account.printAccountDetails();
        assertTrue(details.contains("Balance: 13000"), "El balance en los detalles no es correcto.");
        assertTrue(details.contains("Annual Interest Rate: 5"), "La tasa de interés no es correcta.");
        assertTrue(details.contains("Deposits: 1"), "El número de depósitos no es correcto.");
        assertTrue(details.contains("Withdrawals: 1"), "El número de retiros no es correcto.");
    }
}