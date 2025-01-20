package org.example.account;

public class SavingsAccount extends BankAccount {
    private boolean isActive;

    public SavingsAccount(float initialBalance, float annualInterestRate) {
        super(initialBalance, annualInterestRate);  // Llamada al constructor de la clase base
        this.isActive = initialBalance >= 10000;    // La cuenta se activa si el balance es >= 10000
    }

    // Método para actualizar el estado de la cuenta
    private void updateAccountStatus() {
        isActive = balance >= 10000;  // La cuenta se vuelve inactiva si el balance baja de 10000
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {  // Se verifica si la cuenta está activa antes de permitir el depósito
            balance += amount;
            numDeposits++;  // Se cuenta el depósito
        }
    }

    @Override
    public void withdraw(float amount) {
        if (isActive && amount <= balance) {  // Se verifica si la cuenta está activa y el saldo es suficiente
            balance -= amount;
            numWithdrawals++;  // Se cuenta el retiro
        }
    }

    @Override
    public void generateMonthlyStatement() {
        if (numWithdrawals > 4) {  // Se verifica si se realizaron más de 4 retiros
            monthlyFee += (numWithdrawals - 4) * 1000;  // Comisión extra por cada retiro después del 4to
        }
        super.generateMonthlyStatement();  // Llamada al método de la clase base para generar el estado mensual
        updateAccountStatus();  // Actualiza el estado de la cuenta

        // Imprime el estado mensual
        System.out.println("Monthly Fee: " + monthlyFee + ", Balance after statement: " + balance);
    }

    @Override
    public String printAccountDetails() {
        return super.printAccountDetails() + ", Active: " + isActive + ", Total Transactions: " + (numDeposits + numWithdrawals);
    }

    // Getter para isActive
    public boolean isActive() {
        return isActive;  // Se devuelve el estado actual de la cuenta (activa o inactiva)
    }
}